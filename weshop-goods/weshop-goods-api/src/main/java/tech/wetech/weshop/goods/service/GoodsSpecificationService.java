package tech.wetech.weshop.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.goods.po.GoodsSpecification;
import tech.wetech.weshop.service.IService;

import java.util.List;

@RequestMapping("/goodsSpecification")
public interface GoodsSpecificationService extends IService<GoodsSpecification> {

    @GetMapping("/queryValueByGoodsIdAndIdIn")
    List<String> queryValueByGoodsIdAndIdIn(Integer goodsId, List<Integer> goodsSpecificationIds);
}
