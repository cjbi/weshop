package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.service.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CategoryFilterVO;
import tech.wetech.weshop.vo.GoodsDetailVO;
import tech.wetech.weshop.vo.PageInfoVO;

import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/wechat/goods")
public class WechatGoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsGalleryService goodsGalleryService;

    @Autowired
    private GoodsAttributeService goodsAttributeService;

    @Autowired
    private GoodsIssueService goodsIssueService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentPictureService commentPictureService;

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @Autowired
    private ProductService productService;

    @GetMapping("/count")
    public Result count() {
        return Result.success(goodsService.count(new Goods() {{
            setIsDelete(false);
            setIsOnSale(true);
        }}));
    }


    @GetMapping("/list")
    public Result<PageInfoVO<Goods>> queryGoodsPageInfo(GoodsSearchQuery goodsSearchQuery) {

        //没传分类id就查全部
        if (goodsSearchQuery.getCategoryId() == null) {
            goodsSearchQuery.setCategoryId(0);
        }
        PageInfo<Goods> goodsPageInfo = goodsService.queryGoodsSearchPageInfo(goodsSearchQuery);
        if (goodsPageInfo.getList().isEmpty()) {
            return Result.success();
        }
        List<Integer> categoryIds = goodsService.queryGoodsSearchCategoryIds(goodsSearchQuery);
        //查询二级分类的parentIds
        List<Integer> parentIds = categoryService.queryParentIdsByIdIn(categoryIds);
        //一级分类
        List<CategoryFilterVO> categoryFilter = new LinkedList<CategoryFilterVO>() {{
            add(new CategoryFilterVO(0, "全部", false));
            addAll(categoryService.queryCategoryByIdIn(parentIds).stream()
                    .map(CategoryFilterVO::new)
                    .collect(Collectors.toList()));
        }};

        categoryFilter.forEach(categoryFilterVO -> categoryFilterVO.setChecked(categoryFilterVO.getId().equals(goodsSearchQuery.getCategoryId())));

        PageInfoVO pageInfoVO = new PageInfoVO.Builder(goodsPageInfo)
                .addExtra("categoryFilter", categoryFilter)
                .build();

        return Result.success(pageInfoVO);
    }

    @GetMapping("/detail/{goodsId}")
    public Result<GoodsDetailVO> queryGoodsDetail(@PathVariable Integer goodsId) {
        GoodsDetailVO goodsDetailVO = new GoodsDetailVO();

        Goods goods = goodsService.queryById(goodsId);
        List<GoodsGallery> goodsGalleryVOList = goodsGalleryService.queryList(new GoodsGallery() {{
            setGoodsId(goodsId);
        }});
        List<GoodsDetailVO.GoodsAttributeVO> goodsAttributeVOList = goodsAttributeService.queryGoodsDetailAttributeByGoodsId(goodsId);
        List<GoodsIssue> goodsIssueList = goodsIssueService.queryAll();
        Brand brand = brandService.queryById(goods.getBrandId());

        //商品评价
        int commentCount = commentService.count(new Comment() {{
            setValueId(goodsId);
            setTypeId((byte) 0);
        }});
        List<Comment> hotCommentList = commentService.queryList(new Comment() {{
            setValueId(goodsId);
            setTypeId((byte) 0);
        }});
        List<GoodsDetailVO.CommentsVO.CommentVO> commentVOList = new LinkedList<>();
        for (Comment comment : hotCommentList) {
            GoodsDetailVO.CommentsVO.CommentVO commentVO = new GoodsDetailVO.CommentsVO.CommentVO();
            String content = new String(Base64.getDecoder().decode(comment.getContent()));
            User user = userService.queryById(comment.getUserId());
            List<String> picList = commentPictureService.queryList(new CommentPicture() {{
                setCommentId(comment.getId());
            }}).stream()
                    .map(CommentPicture::getPicUrl)
                    .collect(Collectors.toList());

            commentVO.setContent(content);
            commentVO.setNickname(user.getNickname());
            commentVO.setAvatar(user.getAvatar());
            commentVO.setPicList(picList);
            commentVO.setCreateTime(comment.getCreateTime());
            commentVOList.add(commentVO);
        }
        List<GoodsDetailVO.GoodsSpecificationVO> goodsSpecificationVOList = goodsSpecificationService.queryGoodsDetailSpecificationByGoodsId(goodsId);
        List<Product> productList = productService.queryList(new Product() {{
            setGoodsId(goodsId);
        }});

        goodsDetailVO.setGoods(goods);
        goodsDetailVO.setComments(new GoodsDetailVO.CommentsVO(commentCount, commentVOList));
        goodsDetailVO.setBrand(brand);
        goodsDetailVO.setGoodsGalleryList(goodsGalleryVOList);
        goodsDetailVO.setGoodsAttributeList(goodsAttributeVOList);
        goodsDetailVO.setGoodsIssueList(goodsIssueList);
        goodsDetailVO.setGoodsSpecificationList(goodsSpecificationVOList);
        goodsDetailVO.setProductList(productList);

        //TODO 当前用户是否收藏
        //TODO 记录用户足迹

        return Result.success(goodsDetailVO);
    }


}
