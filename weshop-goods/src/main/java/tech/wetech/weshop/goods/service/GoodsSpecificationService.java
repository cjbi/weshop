package tech.wetech.weshop.goods.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.goods.dto.GoodsSpecificationDTO;
import tech.wetech.weshop.goods.po.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationService extends IService<GoodsSpecification> {

    List<GoodsSpecificationDTO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId);

    List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds);
}
