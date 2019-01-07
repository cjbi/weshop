package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.vo.GoodsDetailVO;
import tech.wetech.weshop.vo.GoodsListVO;
import tech.wetech.weshop.vo.GoodsResultVO;

import java.util.List;

/**
 * @author cjbi
 */
public interface GoodsService extends IService<Goods> {

    List<Goods> queryGoodsByIdIn(List<Integer> ids);

    List<Goods> queryGoodsByCategoryIdIn(List<Integer> categoryIds);

    List<Goods> queryGoodsByCategoryId(Integer categoryId);

    GoodsResultVO queryList(GoodsSearchQuery goodsSearchQuery);

    GoodsDetailVO queryGoodsDetail(Integer goodsId);

    List<GoodsListVO> queryRelatedGoods( Integer goodsId);
}
