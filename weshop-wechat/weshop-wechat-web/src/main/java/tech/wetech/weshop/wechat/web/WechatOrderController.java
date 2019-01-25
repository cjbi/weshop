package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.po.OrderExpress;
import tech.wetech.weshop.query.OrderQuery;
import tech.wetech.weshop.wechat.service.OrderExpressService;
import tech.wetech.weshop.wechat.service.OrderService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.wechat.dto.OrderListDTO;
import tech.wetech.weshop.wechat.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.wechat.dto.OrderDetailDTO;
import tech.wetech.weshop.web.BaseController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/order")
@Validated
public class WechatOrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderExpressService orderExpressService;

    @GetMapping({"/list"})
    public Result<List<OrderListDTO>> queryOrderList(OrderQuery orderQuery) {
        return Result.success(orderService.queryOrderList(orderQuery));
    }

    @GetMapping("/detail")
    public Result<OrderDetailDTO> queryOrderDetail(@NotNull Integer orderId) {
        return Result.success(orderService.queryOrderDetail(orderId));
    }

    /**
     * @return
     */
    @PostMapping("/submit")
    public Result<Order> submitOrder(@Validated @RequestBody OrderSubmitParamDTO orderSubmitParamDTO) {
        return Result.success(orderService.submitOrder(orderSubmitParamDTO));
    }

    /**
     * 获取最新的订单物流信息
     *
     * @param orderId
     * @return
     */
    @GetMapping("/express")
    public Result<OrderExpress> queryLatestExpressInfo(@NotNull Integer orderId) {
        return Result.success(orderExpressService.queryOne(new OrderExpress().setOrderId(orderId)));
    }

}
