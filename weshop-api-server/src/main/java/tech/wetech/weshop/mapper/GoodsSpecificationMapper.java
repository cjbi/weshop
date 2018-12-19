package tech.wetech.weshop.mapper;

import tech.wetech.weshop.bo.GoodsSpecificationBO;
import tech.wetech.weshop.po.GoodsSpecification;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface GoodsSpecificationMapper extends MyMapper<GoodsSpecification> {

    List<GoodsSpecificationBO> selectGoodsDetailSpecificationByGoodsId(Integer goodsId);
}