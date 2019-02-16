package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.order.api.OrderApi;
import tech.wetech.weshop.order.api.OrderExpressApi;
import tech.wetech.weshop.order.dto.OrderDetailDTO;
import tech.wetech.weshop.order.dto.OrderListDTO;
import tech.wetech.weshop.order.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.po.OrderExpress;
import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/order")
@Validated
public class WechatOrderController extends BaseController {

    @Autowired
    private OrderApi orderApi;

    @Autowired
    private OrderExpressApi orderExpressApi;

    @GetMapping({"/list"})
    public Result<List<OrderListDTO>> queryOrderList(OrderQuery orderQuery) {
        return orderApi.queryOrderList(orderQuery);
    }

    @GetMapping("/detail")
    public Result<OrderDetailDTO> queryOrderDetail(@NotNull Integer orderId) {
        return orderApi.queryOrderDetail(orderId);
    }

    /**
     * @return
     */
    @PostMapping("/submit")
    public Result<Order> submitOrder(@Validated @RequestBody OrderSubmitParamDTO orderSubmitParamDTO) {
        return orderApi.submitOrder(orderSubmitParamDTO);
    }

    /**
     * 获取最新的订单物流信息
     *
     * @param orderId
     * @return
     */
    @GetMapping("/express")
    public Result<OrderExpress> queryLatestExpressInfo(@NotNull Integer orderId) {
        return orderExpressApi.queryOne(new OrderExpress().setOrderId(orderId));
    }

}
