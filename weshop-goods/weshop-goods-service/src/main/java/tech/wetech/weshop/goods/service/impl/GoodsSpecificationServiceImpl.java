package tech.wetech.weshop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.goods.mapper.GoodsSpecificationMapper;
import tech.wetech.weshop.goods.po.GoodsSpecification;
import tech.wetech.weshop.goods.service.GoodsSpecificationService;
import tech.wetech.weshop.service.BaseService;

import java.util.List;

@RestController
public class GoodsSpecificationServiceImpl extends BaseService<GoodsSpecification> implements GoodsSpecificationService {

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Override
    public List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(goodsId, goodsSpecificationIds);
    }
}
