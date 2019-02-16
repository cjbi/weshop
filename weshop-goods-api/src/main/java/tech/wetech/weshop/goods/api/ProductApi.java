package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.Product;

@FeignClient(value = "weshop-goods", path = "product")
public interface ProductApi extends Api<Product> {
}
