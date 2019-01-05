package tech.wetech.weshop.service;

import tech.wetech.weshop.po.GoodsAttribute;
import tech.wetech.weshop.vo.GoodsDetailVO;

import java.util.List;

public interface GoodsAttributeService extends IService<GoodsAttribute> {

    List<GoodsDetailVO.GoodsAttributeVO> queryGoodsDetailAttributeByGoodsId(Integer goodsId);

}
