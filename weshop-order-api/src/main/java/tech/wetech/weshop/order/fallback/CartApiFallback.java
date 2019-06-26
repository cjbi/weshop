package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.order.api.CartApi;
import tech.wetech.weshop.order.po.Cart;

@Component
public class CartApiFallback extends ApiFallback<Cart> implements CartApi {
}
