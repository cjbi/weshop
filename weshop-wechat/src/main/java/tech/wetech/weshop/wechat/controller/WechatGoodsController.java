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
import tech.wetech.weshop.goods.dto.GoodsCategoryDTO;
import tech.wetech.weshop.goods.dto.GoodsDetailDTO;
import tech.wetech.weshop.goods.dto.GoodsListDTO;
import tech.wetech.weshop.goods.dto.GoodsResultDTO;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.marketing.dto.BannerInfoDTO;

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
    private GoodsApi goodsApi;

    @GetMapping("/count")
    public Result count() {
        return goodsApi.count(new Goods().setDelete(false).setOnSale(true));
    }

    @GetMapping("/related")
    public Result<List<GoodsListDTO>> queryRelatedGoods(@NotNull @RequestParam("id") Integer id) {
        return goodsApi.queryRelatedGoods(id);
    }

    /**
     * 新品首发
     *
     * @return
     */
    @GetMapping("/new")
    public Result<BannerInfoDTO> newGoods() {
        BannerInfoDTO bannerInfo = new BannerInfoDTO();
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
    public Result<BannerInfoDTO> hotGoods() {
        BannerInfoDTO bannerInfo = new BannerInfoDTO();
        bannerInfo.setName("大家都在买的严选好物");
        bannerInfo.setImgUrl("http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");
        return Result.success(bannerInfo);
    }

    @GetMapping("/category")
    public Result<GoodsCategoryDTO> queryGoodsCategory(@RequestParam("categoryId") @NotNull Integer categoryId) {
        return goodsApi.queryGoodsCategory(categoryId);
    }

    @GetMapping("/list")
    public Result<GoodsResultDTO> queryGoodsPageInfo(GoodsSearchQuery goodsSearchQuery) {
        return goodsApi.queryList(goodsSearchQuery);
    }

    @GetMapping("/detail")
    public Result<GoodsDetailDTO> queryGoodsDetail(@RequestParam("id") @NotNull Integer id) {
        return goodsApi.queryGoodsDetail(id);
    }


}
