package tech.wetech.weshop.admin.service;

import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.OrderQuery;
import tech.wetech.weshop.admin.dto.OrderListDTO;
import tech.wetech.weshop.admin.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.admin.dto.OrderDetailDTO;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface OrderService extends IService<Order> {

    /**
     * 分页查询订单数据
     *
     * @param orderQuery
     * @return
     */
    List<OrderListDTO> queryOrderList(OrderQuery orderQuery);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    OrderDetailDTO queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     *
     * @param orderSubmitParamDTO
     * @return
     */
    Order submitOrder(OrderSubmitParamDTO orderSubmitParamDTO);

}
