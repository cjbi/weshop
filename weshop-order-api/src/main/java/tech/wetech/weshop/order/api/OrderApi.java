package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.order.dto.OrderDetailDTO;
import tech.wetech.weshop.order.dto.OrderListDTO;
import tech.wetech.weshop.order.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.order.fallback.OrderApiFallback;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@FeignClient(value = "weshop-order", path = "order", fallback = OrderApiFallback.class)
public interface OrderApi extends Api<Order> {

    /**
     * 分页查询订单数据
     *
     * @param orderQuery
     * @return
     */
    @PostMapping("/queryOrderList")
    Result<List<OrderListDTO>> queryOrderList(@RequestBody OrderQuery orderQuery);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/queryOrderDetail")
    Result<OrderDetailDTO> queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     *
     * @param orderSubmitParamDTO
     * @return
     */
    @PostMapping("/submitOrder")
    Result<Order> submitOrder(@RequestBody OrderSubmitParamDTO orderSubmitParamDTO);
}
