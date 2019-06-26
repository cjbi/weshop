package tech.wetech.weshop.goods.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.goods.dto.GoodsAttributeDTO;
import tech.wetech.weshop.goods.po.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeService extends IService<GoodsAttribute> {

    List<GoodsAttributeDTO> queryGoodsDetailAttributeByGoodsId(Integer goodsId);

}
