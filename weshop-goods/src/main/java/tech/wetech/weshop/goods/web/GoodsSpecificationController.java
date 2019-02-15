package tech.wetech.weshop.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsSpecificationApi;
import tech.wetech.weshop.goods.po.GoodsSpecification;
import tech.wetech.weshop.goods.service.GoodsSpecificationService;

import java.util.List;

@RestController("/goodsSpecification")
public class GoodsSpecificationController extends BaseApi<GoodsSpecification> implements GoodsSpecificationApi {

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @Override
    public List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return goodsSpecificationService.queryValueByGoodsIdAndIdIn(goodsId, goodsSpecificationIds);
    }
}
