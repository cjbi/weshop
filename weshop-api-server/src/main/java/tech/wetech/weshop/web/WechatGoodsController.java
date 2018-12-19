package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.service.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.GoodsDetailVO;

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
        int count = commentService.count(new Comment() {{
            setValueId(goodsId);
        }});

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
