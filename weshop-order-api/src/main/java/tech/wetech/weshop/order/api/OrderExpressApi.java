package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.order.fallback.OrderExpressApiFallback;
import tech.wetech.weshop.order.po.OrderExpress;

@FeignClient(value = "weshop-order", path = "orderExpress", fallback = OrderExpressApiFallback.class)
public interface OrderExpressApi extends Api<OrderExpress> {
}
