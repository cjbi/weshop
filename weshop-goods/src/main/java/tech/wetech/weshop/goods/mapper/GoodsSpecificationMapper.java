package tech.wetech.weshop.goods.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.goods.bo.GoodsSpecificationBO;
import tech.wetech.weshop.goods.po.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationMapper extends MyMapper<GoodsSpecification> {

    List<GoodsSpecificationBO> selectGoodsDetailSpecificationByGoodsId(Integer goodsId);

    List<String> selectValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds);
}