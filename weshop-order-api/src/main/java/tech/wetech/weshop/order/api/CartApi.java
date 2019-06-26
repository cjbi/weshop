package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.order.fallback.CartApiFallback;
import tech.wetech.weshop.order.po.Cart;

@FeignClient(value = "weshop-order", path = "cart", fallback = CartApiFallback.class)
public interface CartApi extends Api<Cart> {
}
