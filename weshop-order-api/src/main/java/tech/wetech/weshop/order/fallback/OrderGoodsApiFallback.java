package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.order.api.OrderGoodsApi;
import tech.wetech.weshop.order.po.OrderGoods;

@Component
public class OrderGoodsApiFallback extends ApiFallback<OrderGoods> implements OrderGoodsApi {

}
