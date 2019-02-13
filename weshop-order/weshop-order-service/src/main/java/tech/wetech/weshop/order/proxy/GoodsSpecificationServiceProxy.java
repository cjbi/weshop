package tech.wetech.weshop.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.goods.service.GoodsSpecificationService;

@FeignClient(value = "weshop-goods-service")
public interface GoodsSpecificationServiceProxy extends GoodsSpecificationService {
}
