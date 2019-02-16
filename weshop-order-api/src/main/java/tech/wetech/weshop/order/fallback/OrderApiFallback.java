package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.order.api.OrderApi;
import tech.wetech.weshop.order.dto.OrderDetailDTO;
import tech.wetech.weshop.order.dto.OrderListDTO;
import tech.wetech.weshop.order.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@Component
public class OrderApiFallback extends ApiFallback<Order> implements OrderApi {
    @Override
    public Result<List<OrderListDTO>> queryOrderList(OrderQuery orderQuery) {
        return null;
    }

    @Override
    public Result<OrderDetailDTO> queryOrderDetail(Integer orderId) {
        return null;
    }

    @Override
    public Result<Order> submitOrder(OrderSubmitParamDTO orderSubmitParamDTO) {
        return null;
    }
}
