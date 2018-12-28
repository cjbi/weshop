package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
     *
     * @return
     */
    @PostMapping("/submit")
    public Result submitOrder(@Validated @RequestBody OrderSubmitVO orderSubmitVO) {

       return Result.success();
    }

}
