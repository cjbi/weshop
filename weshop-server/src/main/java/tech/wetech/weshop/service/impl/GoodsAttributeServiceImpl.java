package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.bo.GoodsAttributeBO;
import tech.wetech.weshop.mapper.GoodsAttributeMapper;
import tech.wetech.weshop.po.GoodsAttribute;
import tech.wetech.weshop.service.GoodsAttributeService;
import tech.wetech.weshop.vo.GoodsDetailVO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsAttributeServiceImpl extends BaseService<GoodsAttribute> implements GoodsAttributeService {

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Override
    public List<GoodsDetailVO.GoodsAttributeVO> queryGoodsDetailAttributeByGoodsId(Integer goodsId) {
        return goodsAttributeMapper.selectGoodsDetailAttributeByGoodsId(goodsId).stream()
                .map(GoodsAttributeBO::toGoodsAttributeVO)
                .collect(Collectors.toList());
    }
}
