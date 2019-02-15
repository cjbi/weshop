package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.GoodsSpecification;

import java.util.List;

@RequestMapping("/goodsSpecification")
@FeignClient(value = "weshop-goods-api")
public interface GoodsSpecificationApi extends Api<GoodsSpecification> {

    @GetMapping("/queryValueByGoodsIdAndIdIn")
    List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds);
}
