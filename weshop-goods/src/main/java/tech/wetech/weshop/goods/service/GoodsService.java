package tech.wetech.weshop.goods.service;

import tech.wetech.weshop.common.service.IService;
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
public interface GoodsService extends IService<Goods> {

    List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList);

    GoodsResultDTO queryList(GoodsSearchQuery goodsSearchQuery);

    GoodsDetailDTO queryGoodsDetail(Integer goodsId);

    List<GoodsListDTO> queryRelatedGoods(Integer goodsId);

    GoodsCategoryDTO queryGoodsCategory(Integer categoryId);
}
