package tech.wetech.weshop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.order.api.OrderApi;
import tech.wetech.weshop.order.po.Order;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseApi<Order> implements OrderApi {
}
