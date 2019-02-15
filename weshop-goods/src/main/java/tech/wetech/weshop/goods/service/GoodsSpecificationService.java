package tech.wetech.weshop.goods.service;

import tech.wetech.weshop.goods.po.GoodsSpecification;
import tech.wetech.weshop.service.IService;

import java.util.List;

public interface GoodsSpecificationService extends IService<GoodsSpecification> {

    List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds);
}
