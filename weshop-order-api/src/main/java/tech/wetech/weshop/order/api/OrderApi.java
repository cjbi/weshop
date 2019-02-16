package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.order.dto.OrderDetailDTO;
import tech.wetech.weshop.order.dto.OrderListDTO;
import tech.wetech.weshop.order.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.query.OrderQuery;

import java.util.List;

@FeignClient(value = "weshop-order", path = "order")
public interface OrderApi extends Api<Order> {

    /**
     * 分页查询订单数据
     *
     * @param orderQuery
     * @return
     */
    @RequestMapping(value = "/queryOrderList", method = RequestMethod.GET)
    List<OrderListDTO> queryOrderList(OrderQuery orderQuery);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/queryOrderDetail", method = RequestMethod.GET)
    OrderDetailDTO queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     *
     * @param orderSubmitParamDTO
     * @return
     */
    @RequestMapping(value = "/submitOrder", method = RequestMethod.GET)
    Order submitOrder(OrderSubmitParamDTO orderSubmitParamDTO);
}
