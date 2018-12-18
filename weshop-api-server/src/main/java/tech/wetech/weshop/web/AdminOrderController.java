package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.domain.Order;
import tech.wetech.weshop.enums.OrderStatusEnum;
import tech.wetech.weshop.enums.PayStatusEnum;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.OrderVO;
import tech.wetech.weshop.vo.PageInfoVO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/order")
public class AdminOrderController extends BaseController<Order> {

    @Autowired
    private OrderService orderService;

    @Override
    public Result<PageInfoVO<Order>> queryPageInfo(Order entity, Integer pageNum, Integer pageSize) {
        Map<String, Object> extra = new HashMap(16) {{
            put("orderStatus", Arrays.stream(OrderStatusEnum.values()).collect(Collectors.toMap(o -> o, OrderStatusEnum::getName)));
            put("payStatus", Arrays.stream(PayStatusEnum.values()).collect(Collectors.toMap(p -> p, PayStatusEnum::getName)));
        }};
        Result<PageInfoVO<Order>> result = super.queryPageInfo(entity, pageNum, pageSize);
        result.getData().setExtra(extra);
        return result;
    }

    @GetMapping("/detail/{orderId}")
    public Result<OrderVO> queryOrderDetail(@PathVariable("orderId") Integer orderId) {
        return Result.success(orderService.queryOrderDetail(orderId));
    }

}
