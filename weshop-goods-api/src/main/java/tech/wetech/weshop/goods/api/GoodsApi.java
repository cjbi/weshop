package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.dto.GoodsCategoryDTO;
import tech.wetech.weshop.goods.dto.GoodsDetailDTO;
import tech.wetech.weshop.goods.dto.GoodsListDTO;
import tech.wetech.weshop.goods.dto.GoodsResultDTO;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/goods")
@FeignClient(value = "weshop-goods-api")
public interface GoodsApi extends Api<Goods> {

    @GetMapping("/queryListByCategoryIdIn")
    List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList);

    @GetMapping("/queryList2")
    GoodsResultDTO queryList(GoodsSearchQuery goodsSearchQuery);

    @GetMapping("/queryGoodsDetail")
    GoodsDetailDTO queryGoodsDetail(Integer goodsId);

    @GetMapping("/queryRelatedGoods")
    List<GoodsListDTO> queryRelatedGoods(Integer goodsId);

    @GetMapping("/queryGoodsCategory")
    GoodsCategoryDTO queryGoodsCategory(Integer categoryId);
}
