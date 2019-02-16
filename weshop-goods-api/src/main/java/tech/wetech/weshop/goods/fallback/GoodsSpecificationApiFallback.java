package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.GoodsSpecificationApi;
import tech.wetech.weshop.goods.po.GoodsSpecification;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@Component
public class GoodsSpecificationApiFallback extends ApiFallback<GoodsSpecification> implements GoodsSpecificationApi {
    @Override
    public Result<List<String>> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds) {
        return Result.failure(ResultCodeEnum.INTERNAL_SERVER_ERROR);
    }
}
