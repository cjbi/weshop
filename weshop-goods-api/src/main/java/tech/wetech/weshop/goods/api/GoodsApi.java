package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.dto.GoodsCategoryDTO;
import tech.wetech.weshop.goods.dto.GoodsDetailDTO;
import tech.wetech.weshop.goods.dto.GoodsListDTO;
import tech.wetech.weshop.goods.dto.GoodsResultDTO;
import tech.wetech.weshop.goods.fallback.GoodsApiFallback;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.utils.Result;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@FeignClient(value = "weshop-goods", path = "goods", fallback = GoodsApiFallback.class)
public interface GoodsApi extends Api<Goods> {

    @GetMapping("/queryListByCategoryIdIn")
    Result<List<Goods>> queryListByCategoryIdIn(List<Integer> categoryIdList);

    @GetMapping("/queryList2")
    Result<GoodsResultDTO> queryList(GoodsSearchQuery goodsSearchQuery);

    @GetMapping("/queryGoodsDetail")
    Result<GoodsDetailDTO> queryGoodsDetail(Integer goodsId);

    @GetMapping("/queryRelatedGoods")
    Result<List<GoodsListDTO>> queryRelatedGoods(Integer goodsId);

    @GetMapping("/queryGoodsCategory")
    Result<GoodsCategoryDTO> queryGoodsCategory(Integer categoryId);
}
