package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.OrderExpress;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.OrderSubmitVO;

@RestController
@RequestMapping("/wechat/order")
@Validated
public class WechatOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @return
     */
    @PostMapping("/submit")
    public Result submitOrder(@Validated @RequestBody OrderSubmitVO orderSubmitVO) {
        return Result.success(orderService.submitOrder(orderSubmitVO));
    }

    /**
     * 获取最新的订单物流信息
     *
     * @param orderId
     * @return
     */
    @GetMapping("/express/{orderId}")
    public Result<OrderExpress> queryLatestExpressInfo(@PathVariable Integer orderId) {
        return Result.success();
    }

}
