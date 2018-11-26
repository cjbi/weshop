package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.OrderStatusEnum;
import tech.wetech.weshop.enums.PayStatusEnum;
import tech.wetech.weshop.query.OrderPageQuery;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.OrderVO;
import tech.wetech.weshop.vo.PageInfoVO;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryOrderPageInfo(OrderPageQuery orderPageQuery) {
        PageInfo pageInfo = orderService.queryOrderPageInfo(orderPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO.Builder(pageInfo)
                .addExtra("orderStatus", Arrays.stream(OrderStatusEnum.values()).collect(Collectors.toMap(o -> o, OrderStatusEnum::getName)))
                .addExtra("payStatus", Arrays.stream(PayStatusEnum.values()).collect(Collectors.toMap(p -> p, PayStatusEnum::getName)))
                .build();
        return Result.success(pageInfoVO);
    }

    @GetMapping
    public OrderVO queryOrderDetail() {
        return new OrderVO();
    }

}
