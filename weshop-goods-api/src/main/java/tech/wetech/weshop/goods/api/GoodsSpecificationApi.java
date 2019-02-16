package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.GoodsSpecification;

import java.util.List;

@FeignClient(value = "weshop-goods", path = "goodsSpecification")
public interface GoodsSpecificationApi extends Api<GoodsSpecification> {

    @RequestMapping(value = "/queryValueByGoodsIdAndIdIn", method = RequestMethod.GET)
    List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds);
}
