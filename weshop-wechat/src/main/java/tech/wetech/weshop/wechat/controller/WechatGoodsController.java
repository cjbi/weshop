package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.api.GoodsApi;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.wechat.service.WechatGoodsService;
import tech.wetech.weshop.wechat.vo.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/wechat/goods")
@Validated
public class WechatGoodsController extends BaseController {

    @Autowired
    private WechatGoodsService wechatGoodsService;

    @Autowired
    private GoodsApi goodsApi;

    @GetMapping("/count")
    public Result count() {
        return goodsApi.count(new Goods().setDelete(false).setOnSale(true));
    }

    @GetMapping("/related")
    public Result<List<GoodsListVO>> queryRelatedGoods(@NotNull @RequestParam("id") Integer id) {
        return Result.success(wechatGoodsService.queryRelatedGoods(id));
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
        return Result.success(wechatGoodsService.queryGoodsCategory(categoryId));
    }

    @GetMapping("/list")
    public Result<GoodsResultVO> queryGoodsPageInfo(GoodsSearchQuery goodsSearchQuery) {
        return Result.success(wechatGoodsService.queryList(goodsSearchQuery));
    }

    @GetMapping("/detail")
    public Result<GoodsDetailVO> queryGoodsDetail(@RequestParam("id") @NotNull Integer id) {
        return Result.success(wechatGoodsService.queryGoodsDetail(id));
    }


}
