package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.goods.dto.GoodsCategoryDTO;
import tech.wetech.weshop.goods.dto.GoodsDetailDTO;
import tech.wetech.weshop.goods.dto.GoodsListDTO;
import tech.wetech.weshop.goods.dto.GoodsResultDTO;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.goods.service.GoodsService;
import tech.wetech.weshop.marketing.dto.BannerInfoDTO;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

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
    private GoodsService goodsService;

    @GetMapping("/count")
    public Result count() {
        return Result.success(goodsService.count(new Goods().setDelete(false).setOnSale(true)));
    }

    @GetMapping("/related")
    public Result<List<GoodsListDTO>> queryRelatedGoods(@NotNull Integer id) {
        return Result.success(goodsService.queryRelatedGoods(id));
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
        return Result.success(goodsService.queryGoodsCategory(categoryId));
    }

    @GetMapping("/list")
    public Result<GoodsResultDTO> queryGoodsPageInfo(GoodsSearchQuery goodsSearchQuery) {
        return Result.success(goodsService.queryList(goodsSearchQuery));
    }

    @GetMapping("/detail")
    public Result<GoodsDetailDTO> queryGoodsDetail(@RequestParam("id") @NotNull Integer id) {
        return Result.success(goodsService.queryGoodsDetail(id));
    }


}
