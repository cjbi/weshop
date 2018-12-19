package tech.wetech.weshop.service;

import tech.wetech.weshop.po.GoodsSpecification;
import tech.wetech.weshop.vo.GoodsDetailVO;

import java.util.List;

public interface GoodsSpecificationService extends IService<GoodsSpecification> {

    List<GoodsDetailVO.GoodsSpecificationVO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId);

}
