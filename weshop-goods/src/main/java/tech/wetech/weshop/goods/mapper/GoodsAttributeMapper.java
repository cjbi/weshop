package tech.wetech.weshop.goods.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.goods.dto.GoodsAttributeDTO;
import tech.wetech.weshop.goods.po.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeMapper extends MyMapper<GoodsAttribute> {

    List<GoodsAttributeDTO> selectGoodsDetailAttributeByGoodsId(Integer goodsId);
}