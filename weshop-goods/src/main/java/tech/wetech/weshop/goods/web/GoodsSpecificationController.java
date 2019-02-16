package tech.wetech.weshop.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsSpecificationApi;
import tech.wetech.weshop.goods.po.GoodsSpecification;
import tech.wetech.weshop.goods.service.GoodsSpecificationService;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/goodsSpecification")
public class GoodsSpecificationController extends BaseApi<GoodsSpecification> implements GoodsSpecificationApi {

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @Override
    public Result<List<String>> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return Result.success(goodsSpecificationService.queryValueByGoodsIdAndIdIn(goodsId, goodsSpecificationIds));
    }
}
