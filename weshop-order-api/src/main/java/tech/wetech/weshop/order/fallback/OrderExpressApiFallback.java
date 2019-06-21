package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.order.api.OrderExpressApi;
import tech.wetech.weshop.order.po.OrderExpress;

@Component
public class OrderExpressApiFallback extends ApiFallback<OrderExpress> implements OrderExpressApi {
}
