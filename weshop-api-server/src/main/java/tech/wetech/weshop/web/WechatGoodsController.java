package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.service.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.*;

import javax.validation.constraints.NotNull;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/wechat/goods")
@Validated
public class WechatGoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RelatedGoodsService relatedGoodsService;

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
        return Result.success(goodsService.count(new Goods().setDelete(false).setOnSale(true)));
    }

    @GetMapping("/related")
    public Result<List<GoodsListVO>> queryRelatedGoods(@NotNull Integer goodsId) {
        List<RelatedGoods> relatedGoodsList = relatedGoodsService.queryList(new RelatedGoods() {{
            setGoodsId(goodsId);
        }});
        List<GoodsListVO> goodsList = null;
        if (relatedGoodsList.isEmpty()) {
            //查找同分类下的商品
            Goods goods = goodsService.queryById(goodsId);
            goodsList = goodsService.queryGoodsByCategoryId(goods.getCategoryId()).stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        } else {
            List<Integer> goodsIdList = relatedGoodsList.stream()
                    .map(RelatedGoods::getGoodsId)
                    .collect(Collectors.toList());
            goodsList = goodsService.queryGoodsByIdIn(goodsIdList).stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        }
        return Result.success(goodsList);
    }

    /**
     * 新品首发
     *
     * @return
     */
    @GetMapping("/new")
    public Result<BannerInfoVO> newGoods() {
        BannerInfoVO bannerInfo = new BannerInfoVO();
        bannerInfo.setName("坚持初心，为你寻觅世间好物");
        bannerInfo.setImgUrl("http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");
        return Result.success(bannerInfo);
    }

    /**
     * 人气推荐
     *
     * @return
     */
    @GetMapping("/hot")
    public Result<BannerInfoVO> hotGoods() {
        BannerInfoVO bannerInfo = new BannerInfoVO();
        bannerInfo.setName("大家都在买的严选好物");
        bannerInfo.setImgUrl("http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");
        return Result.success(bannerInfo);
    }

    @GetMapping("/category")
    public Result<GoodsCategoryVO> queryGoodsCategory(@RequestParam("categoryId") @NotNull Integer categoryId) {
        Category currentCategory = categoryService.queryById(categoryId);
        if (currentCategory == null) {
            return Result.success();
        }
        Category parentCategory = categoryService.queryById(currentCategory.getParentId());
        List<Category> brotherCategory = categoryService.queryList(new Category() {{
            setParentId(currentCategory.getParentId());
        }});
        return Result.success(new GoodsCategoryVO(currentCategory, parentCategory, brotherCategory));
    }


    @GetMapping("/list")
    public Result<List<Goods>> queryGoodsPageInfo(GoodsSearchQuery goodsSearchQuery) {

        //没传分类id就查全部
        if (goodsSearchQuery.getCategoryId() == null) {
            goodsSearchQuery.setCategoryId(0);
        }
        List<Goods> goodsList = goodsService.queryList(goodsSearchQuery);

        if (goodsList.isEmpty()) {
            return Result.success();
        }
        List<Integer> categoryIds = goodsService.queryGoodsCategoryIds(goodsSearchQuery);
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

        return Result.success(goodsList).addExtra("categoryFilter", categoryFilter);
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
