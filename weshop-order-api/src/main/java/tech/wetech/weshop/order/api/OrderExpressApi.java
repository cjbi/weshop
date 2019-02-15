package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.order.po.OrderExpress;

@RequestMapping("/orderExpress")
@FeignClient(value = "weshop-order-service")
public interface OrderExpressApi extends Api<OrderExpress> {
}
