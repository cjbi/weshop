package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.vo.GoodsCategoryVO;
import tech.wetech.weshop.vo.GoodsDetailVO;
import tech.wetech.weshop.vo.GoodsListVO;
import tech.wetech.weshop.vo.GoodsResultVO;

import java.util.List;

/**
 * @author cjbi
 */
public interface GoodsService extends IService<Goods> {

    GoodsResultVO queryList(GoodsSearchQuery goodsSearchQuery);

    GoodsDetailVO queryGoodsDetail(Integer goodsId);

    List<GoodsListVO> queryRelatedGoods( Integer goodsId);

    GoodsCategoryVO queryGoodsCategory(Integer categoryId);
}
