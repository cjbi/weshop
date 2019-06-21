package tech.wetech.weshop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.order.api.OrderExpressApi;
import tech.wetech.weshop.order.po.OrderExpress;

@RestController
@RequestMapping("/orderExpress")
public class OrderExpressController extends BaseApi<OrderExpress> implements OrderExpressApi {
}
