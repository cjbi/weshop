package tech.wetech.weshop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.order.api.CartApi;
import tech.wetech.weshop.order.po.Cart;

@RequestMapping("/cart")
@RestController
public class CartController extends BaseApi<Cart> implements CartApi {
}
