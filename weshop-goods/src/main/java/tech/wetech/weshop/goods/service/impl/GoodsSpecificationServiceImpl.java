package tech.wetech.weshop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.goods.dto.GoodsSpecificationDTO;
import tech.wetech.weshop.goods.mapper.GoodsSpecificationMapper;
import tech.wetech.weshop.goods.po.GoodsSpecification;
import tech.wetech.weshop.goods.service.GoodsSpecificationService;

import java.util.List;

@Service
public class GoodsSpecificationServiceImpl extends BaseService<GoodsSpecification> implements GoodsSpecificationService {

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Override
    public List<GoodsSpecificationDTO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        return goodsSpecificationMapper.selectGoodsDetailSpecificationByGoodsId(goodsId);
    }

    @Override
    public List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(goodsId, goodsSpecificationIds);
    }
}
