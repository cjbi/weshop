package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.bo.GoodsSpecificationBO;
import tech.wetech.weshop.mapper.GoodsSpecificationMapper;
import tech.wetech.weshop.po.GoodsSpecification;
import tech.wetech.weshop.service.GoodsSpecificationService;
import tech.wetech.weshop.vo.GoodsDetailVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsSpecificationServiceImpl extends BaseService<GoodsSpecification> implements GoodsSpecificationService {

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Override
    public List<GoodsDetailVO.GoodsSpecificationVO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        List<GoodsDetailVO.GoodsSpecificationVO> goodsSpecificationVOList = new LinkedList<>();
        List<GoodsSpecificationBO> goodsSpecificationBOList = goodsSpecificationMapper.selectGoodsDetailSpecificationByGoodsId(goodsId);

        goodsSpecificationBOList.stream()
                .collect(Collectors.toMap(GoodsSpecificationBO::getSpecificationId, g -> g, (g1, g2) -> g2))
                .forEach((k, v) -> {
                    GoodsDetailVO.GoodsSpecificationVO goodsSpecificationVO = new GoodsDetailVO.GoodsSpecificationVO();
                    goodsSpecificationVO.setId(k);
                    goodsSpecificationVO.setName(v.getName());
                    goodsSpecificationVO.setGoodsSpecificationList(
                            goodsSpecificationBOList.stream()
                                    .filter(g -> g.getSpecificationId().equals(v.getSpecificationId()))
                                    .collect(Collectors.toList())
                    );
                    goodsSpecificationVOList.add(goodsSpecificationVO);
                });

        return goodsSpecificationVOList;
    }
}
