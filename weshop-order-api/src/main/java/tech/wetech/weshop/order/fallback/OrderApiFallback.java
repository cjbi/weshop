package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.order.api.OrderApi;
import tech.wetech.weshop.order.po.Order;

@Component
public class OrderApiFallback extends ApiFallback<Order> implements OrderApi {
}
