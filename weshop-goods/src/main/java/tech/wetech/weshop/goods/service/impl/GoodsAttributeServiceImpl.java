package tech.wetech.weshop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.goods.dto.GoodsAttributeDTO;
import tech.wetech.weshop.goods.mapper.GoodsAttributeMapper;
import tech.wetech.weshop.goods.po.GoodsAttribute;
import tech.wetech.weshop.goods.service.GoodsAttributeService;

import java.util.List;

@Service
public class GoodsAttributeServiceImpl extends BaseService<GoodsAttribute> implements GoodsAttributeService {

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Override
    public List<GoodsAttributeDTO> queryGoodsDetailAttributeByGoodsId(Integer goodsId) {
        return goodsAttributeMapper.selectGoodsDetailAttributeByGoodsId(goodsId);
    }
}
