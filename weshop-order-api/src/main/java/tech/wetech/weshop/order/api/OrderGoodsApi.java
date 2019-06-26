package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.order.fallback.OrderGoodsApiFallback;
import tech.wetech.weshop.order.po.OrderGoods;

@FeignClient(value = "weshop-order", path = "orderGoods", fallback = OrderGoodsApiFallback.class)
public interface OrderGoodsApi extends Api<OrderGoods> {
}
