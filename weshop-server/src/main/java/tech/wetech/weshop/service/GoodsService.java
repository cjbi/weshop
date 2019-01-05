package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsSearchQuery;

import java.util.List;

/**
 * @author cjbi
 */
public interface GoodsService extends IService<Goods> {

    List<Goods> queryGoodsByIdIn(List<Integer> ids);

    List<Goods> queryGoodsByCategoryIdIn(List<Integer> categoryIds);

    List<Goods> queryGoodsByCategoryId(Integer categoryId);

    List<Goods> queryList(GoodsSearchQuery goodsSearchQuery);

    List<Integer> queryGoodsCategoryIds(GoodsSearchQuery goodsSearchQuery);

}
