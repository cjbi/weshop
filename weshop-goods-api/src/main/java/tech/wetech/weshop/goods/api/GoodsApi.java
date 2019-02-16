package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
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
@FeignClient(value = "weshop-goods", path = "goods")
public interface GoodsApi extends Api<Goods> {

    @RequestMapping(value = "/queryListByCategoryIdIn", method = RequestMethod.GET)
    List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList);

    @RequestMapping(value = "/queryList2", method = RequestMethod.GET)
    GoodsResultDTO queryList(GoodsSearchQuery goodsSearchQuery);

    @RequestMapping(value = "/queryGoodsDetail", method = RequestMethod.GET)
    GoodsDetailDTO queryGoodsDetail(Integer goodsId);

    @RequestMapping(value = "/queryRelatedGoods", method = RequestMethod.GET)
    List<GoodsListDTO> queryRelatedGoods(Integer goodsId);

    @RequestMapping(value = "/queryGoodsCategory", method = RequestMethod.GET)
    GoodsCategoryDTO queryGoodsCategory(Integer categoryId);
}
