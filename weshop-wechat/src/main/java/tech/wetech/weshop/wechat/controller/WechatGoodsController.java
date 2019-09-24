package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.ResultWrapper;
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
    public ResultWrapper count() {
        return goodsApi.count(new Goods().setDelete(false).setOnSale(true));
    }

    @GetMapping("/related")
    public ResultWrapper<List<GoodsListVO>> queryRelatedGoods(@NotNull @RequestParam("id") Integer id) {
        return ResultWrapper.success(wechatGoodsService.queryRelatedGoods(id));
    }

    /**
     * 新品首发
     *
     * @return
     */
    @GetMapping("/new")
    public ResultWrapper<BannerInfoVO> newGoods() {
        BannerInfoVO bannerInfo = new BannerInfoVO();
        bannerInfo.setName("坚持初心，为你寻觅世间好物");
        bannerInfo.setImgUrl("http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");
        return ResultWrapper.success(bannerInfo);
    }

    /**
     * 人气推荐
     *
     * @return
     */
    @GetMapping("/hot")
    public ResultWrapper<BannerInfoVO> hotGoods() {
        BannerInfoVO bannerInfo = new BannerInfoVO();
        bannerInfo.setName("大家都在买的严选好物");
        bannerInfo.setImgUrl("http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");
        return ResultWrapper.success(bannerInfo);
    }

    @GetMapping("/category")
    public ResultWrapper<GoodsCategoryVO> queryGoodsCategory(@RequestParam("categoryId") @NotNull Integer categoryId) {
        return ResultWrapper.success(wechatGoodsService.queryGoodsCategory(categoryId));
    }

    @GetMapping("/list")
    public ResultWrapper<GoodsResultVO> queryGoodsPageInfo(GoodsSearchQuery goodsSearchQuery) {
        return ResultWrapper.success(wechatGoodsService.queryList(goodsSearchQuery));
    }

    @GetMapping("/detail")
    public ResultWrapper<GoodsDetailVO> queryGoodsDetail(@RequestParam("id") @NotNull Integer id) {
        return ResultWrapper.success(wechatGoodsService.queryGoodsDetail(id));
    }


}
