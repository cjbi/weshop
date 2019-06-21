package tech.wetech.weshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.order.api.OrderApi;
import tech.wetech.weshop.order.dto.OrderDetailDTO;
import tech.wetech.weshop.order.dto.OrderListDTO;
import tech.wetech.weshop.order.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseApi<Order> implements OrderApi {

    @Autowired
    private OrderService orderService;

    @Override
    public Result<List<OrderListDTO>> queryOrderList(OrderQuery orderQuery) {
        return Result.success(orderService.queryOrderList(orderQuery));
    }

    @Override
    public Result<OrderDetailDTO> queryOrderDetail(Integer orderId) {
        return Result.success(orderService.queryOrderDetail(orderId));
    }

    @Override
    public Result<Order> submitOrder(OrderSubmitParamDTO orderSubmitParamDTO) {
        return Result.success(orderService.submitOrder(orderSubmitParamDTO));
    }
}
