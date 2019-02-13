package tech.wetech.weshop.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.goods.service.ProductService;

@FeignClient(value = "weshop-goods-service")
public interface ProductServiceProxy extends ProductService {
}
