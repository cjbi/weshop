package tech.wetech.weshop.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.order.dto.OrderDetailDTO;
import tech.wetech.weshop.order.dto.OrderListDTO;
import tech.wetech.weshop.order.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */

@RequestMapping("/order")
@FeignClient(value = "weshop-order-service")
public interface OrderService extends IService<Order> {

    /**
     * 分页查询订单数据
     *
     * @param orderQuery
     * @return
     */
    @GetMapping("/queryOrderList")
    List<OrderListDTO> queryOrderList(OrderQuery orderQuery);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/queryOrderDetail")
    OrderDetailDTO queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     *
     * @param orderSubmitParamDTO
     * @return
     */
    @GetMapping("/submitOrder")
    Order submitOrder(OrderSubmitParamDTO orderSubmitParamDTO);

}
