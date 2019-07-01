package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.dto.GoodsSpecificationDTO;
import tech.wetech.weshop.goods.fallback.GoodsSpecificationApiFallback;
import tech.wetech.weshop.goods.po.GoodsSpecification;

import java.util.List;

@FeignClient(value = "weshop-goods", path = "goodsSpecification", fallback = GoodsSpecificationApiFallback.class)
public interface GoodsSpecificationApi extends Api<GoodsSpecification> {

    @GetMapping("/queryGoodsDetailSpecificationByGoodsId")
    Result<List<GoodsSpecificationDTO>> queryGoodsDetailSpecificationByGoodsId(@RequestParam("goodsId") Integer goodsId);

    @GetMapping("/queryValueByGoodsIdAndIdIn")
    Result<List<String>> queryValueByGoodsIdAndIdIn(@RequestParam("goodsId") Integer goodsId, @RequestParam("goodsSpecificationIds") List<Integer> goodsSpecificationIds);
}
