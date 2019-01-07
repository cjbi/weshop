package tech.wetech.weshop.web;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.po.RelatedGoods;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.service.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.*;

import javax.validation.constraints.NotNull;
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

    @GetMapping("/count")
    public Result count() {
        return Result.success(goodsService.count(new Goods().setDelete(false).setOnSale(true)));
    }

    @GetMapping("/related")
    public Result<List<GoodsListVO>> queryRelatedGoods(@NotNull Integer id) {
        List<RelatedGoods> relatedGoodsList = relatedGoodsService.queryList(new RelatedGoods().setGoodsId(id));
        List<GoodsListVO> goodsList = null;

        if (relatedGoodsList.isEmpty()) {
            //查找同分类下的商品
            Goods goods = goodsService.queryById(id);
            PageHelper.startPage(1, 8);
            goodsList = goodsService.queryGoodsByCategoryId(goods.getCategoryId()).stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        } else {
            List<Integer> goodsIdList = relatedGoodsList.stream()
                    .map(RelatedGoods::getGoodsId)
                    .collect(Collectors.toList());
            PageHelper.startPage(1, 8);
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
        List<Category> brotherCategory = categoryService.queryList(new Category().setParentId(currentCategory.getParentId()));
        return Result.success(new GoodsCategoryVO(currentCategory, parentCategory, brotherCategory));
    }

    @GetMapping("/list")
    public Result<GoodsResultVO> queryGoodsPageInfo(GoodsSearchQuery goodsSearchQuery) {
        return Result.success(goodsService.queryList(goodsSearchQuery));
    }

    @GetMapping("/detail")
    public Result<GoodsDetailVO> queryGoodsDetail(Integer id) {
        return Result.success(goodsService.queryGoodsDetail(id));
    }


}
