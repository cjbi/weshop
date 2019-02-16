package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.enums.ResultCodeEnum;
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
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<OrderDetailDTO> queryOrderDetail(Integer orderId) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Order> submitOrder(OrderSubmitParamDTO orderSubmitParamDTO) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }
}
