package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.po.OrderExpress;
import tech.wetech.weshop.query.OrderQuery;
import tech.wetech.weshop.service.OrderExpressService;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.OrderListVO;
import tech.wetech.weshop.vo.OrderSubmitParamVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/order")
@Validated
public class WechatOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderExpressService orderExpressService;

    @GetMapping("/list")
    public Result<List<OrderListVO>> queryOrderList(OrderQuery orderQuery) {
        return Result.success(orderService.queryOrderList(orderQuery));
    }

    /**
     * @return
     */
    @PostMapping("/submit")
    public Result<Order> submitOrder(@Validated @RequestBody OrderSubmitParamVO orderSubmitParamVO) {
        return Result.success(orderService.submitOrder(orderSubmitParamVO));
    }

    /**
     * 获取最新的订单物流信息
     *
     * @param orderId
     * @return
     */
    @GetMapping("/express/{orderId}")
    public Result<OrderExpress> queryLatestExpressInfo(@PathVariable Integer orderId) {
        return Result.success(orderExpressService.queryOne(new OrderExpress().setOrderId(orderId)));
    }

}
