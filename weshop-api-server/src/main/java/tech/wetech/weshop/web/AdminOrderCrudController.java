package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.OrderStatusEnum;
import tech.wetech.weshop.enums.PayStatusEnum;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.OrderVO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/order")
public class AdminOrderCrudController extends BaseCrudController<Order> {

    @Autowired
    private OrderService orderService;

    @Override
    public Result<List<Order>> queryList(Order entity, PageQuery pageQuery) {
        return super.queryList(entity, pageQuery)
                .addExtra("orderStatus", Arrays.stream(OrderStatusEnum.values()).collect(Collectors.toMap(o -> o, OrderStatusEnum::getName)))
                .addExtra("payStatus", Arrays.stream(PayStatusEnum.values()).collect(Collectors.toMap(p -> p, PayStatusEnum::getName)));
    }

    @GetMapping("/detail/{orderId}")
    public Result<OrderVO> queryOrderDetail(@PathVariable("orderId") Integer orderId) {
        return Result.success(orderService.queryOrderDetail(orderId));
    }

}
