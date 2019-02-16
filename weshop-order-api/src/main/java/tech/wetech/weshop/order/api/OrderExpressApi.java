package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.order.po.OrderExpress;

@FeignClient(value = "weshop-order", path = "orderExpress")
public interface OrderExpressApi extends Api<OrderExpress> {
}
