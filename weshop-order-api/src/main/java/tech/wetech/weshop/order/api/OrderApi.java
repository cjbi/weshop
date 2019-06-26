package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.order.fallback.OrderApiFallback;
import tech.wetech.weshop.order.po.Order;

@FeignClient(value = "weshop-order", path = "order", fallback = OrderApiFallback.class)
public interface OrderApi extends Api<Order> {
}
