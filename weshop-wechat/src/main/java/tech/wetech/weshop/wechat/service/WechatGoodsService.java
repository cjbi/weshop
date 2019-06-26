package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.wechat.vo.GoodsCategoryVO;
import tech.wetech.weshop.wechat.vo.GoodsDetailVO;
import tech.wetech.weshop.wechat.vo.GoodsListVO;
import tech.wetech.weshop.wechat.vo.GoodsResultVO;

import java.util.List;

public interface WechatGoodsService {

    List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList);

    GoodsResultVO queryList(GoodsSearchQuery goodsSearchQuery);

    GoodsDetailVO queryGoodsDetail(Integer goodsId);

    List<GoodsListVO> queryRelatedGoods(Integer goodsId);

    GoodsCategoryVO queryGoodsCategory(Integer categoryId);

}
