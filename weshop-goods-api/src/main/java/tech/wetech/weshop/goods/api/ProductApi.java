package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.ProductApiFallback;
import tech.wetech.weshop.goods.po.Product;

@FeignClient(value = "weshop-goods", path = "product", fallback = ProductApiFallback.class)
public interface ProductApi extends Api<Product> {
}
