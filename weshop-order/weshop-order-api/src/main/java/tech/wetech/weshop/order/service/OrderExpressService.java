package tech.wetech.weshop.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.order.po.OrderExpress;
import tech.wetech.weshop.service.IService;

@RequestMapping("/orderExpress")
@FeignClient(value = "weshop-order-service")
public interface OrderExpressService extends IService<OrderExpress> {
}
