package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.order.api.OrderExpressApi;
import tech.wetech.weshop.order.po.OrderExpress;
import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.wechat.service.WechatOrderService;
import tech.wetech.weshop.wechat.vo.OrderDetailVO;
import tech.wetech.weshop.wechat.vo.OrderListVO;
import tech.wetech.weshop.wechat.vo.OrderSubmitParamVO;
import tech.wetech.weshop.wechat.vo.OrderSubmitResultVO;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/order")
@Validated
public class WechatOrderController extends BaseController {

    @Autowired
    private WechatOrderService wechatOrderService;

    @Autowired
    private OrderExpressApi orderExpressApi;

    @GetMapping({"/list"})
    public Result<List<OrderListVO>> queryOrderList(OrderQuery orderQuery) {
        return Result.success(wechatOrderService.queryOrderList(orderQuery));
    }

    @GetMapping("/detail")
    public Result<OrderDetailVO> queryOrderDetail(@NotNull Integer orderId) {
        return Result.success(wechatOrderService.queryOrderDetail(orderId));
    }

    /**
     * @return
     */
    @PostMapping("/submit")
    public Result<OrderSubmitResultVO> submitOrder(@Validated @RequestBody OrderSubmitParamVO orderSubmitParamDTO) {
        return Result.success(wechatOrderService.submitOrder(orderSubmitParamDTO));
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
