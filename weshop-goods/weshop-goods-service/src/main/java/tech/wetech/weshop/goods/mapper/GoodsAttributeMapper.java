package tech.wetech.weshop.goods.mapper;

import tech.wetech.weshop.goods.bo.GoodsAttributeBO;
import tech.wetech.weshop.goods.po.GoodsAttribute;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface GoodsAttributeMapper extends MyMapper<GoodsAttribute> {

    List<GoodsAttributeBO> selectGoodsDetailAttributeByGoodsId(Integer goodsId);
}