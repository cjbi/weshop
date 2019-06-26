package tech.wetech.weshop.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.order.api.OrderGoodsApi;
import tech.wetech.weshop.order.po.OrderGoods;

@RestController
@RequestMapping("/orderGoods")
public class OrderGoodsController extends BaseApi<OrderGoods> implements OrderGoodsApi {
}
