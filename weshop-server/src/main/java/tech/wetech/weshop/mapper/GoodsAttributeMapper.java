package tech.wetech.weshop.mapper;

import tech.wetech.weshop.bo.GoodsAttributeBO;
import tech.wetech.weshop.po.GoodsAttribute;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface GoodsAttributeMapper extends MyMapper<GoodsAttribute> {

    List<GoodsAttributeBO> selectGoodsDetailAttributeByGoodsId(Integer goodsId);
}