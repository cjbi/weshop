package tech.wetech.weshop.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.goods.dto.GoodsCategoryDTO;
import tech.wetech.weshop.goods.dto.GoodsDetailDTO;
import tech.wetech.weshop.goods.dto.GoodsListDTO;
import tech.wetech.weshop.goods.dto.GoodsResultDTO;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/goods")
public interface GoodsService extends IService<Goods> {

    @GetMapping("/queryListByCategoryIdIn")
    List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList);

    @GetMapping("/queryList")
    GoodsResultDTO queryList(GoodsSearchQuery goodsSearchQuery);

    @GetMapping("/queryGoodsDetail")
    GoodsDetailDTO queryGoodsDetail(Integer goodsId);

    @GetMapping("/queryRelatedGoods")
    List<GoodsListDTO> queryRelatedGoods(Integer goodsId);

    @GetMapping("/queryGoodsCategory")
    GoodsCategoryDTO queryGoodsCategory(Integer categoryId);
}
