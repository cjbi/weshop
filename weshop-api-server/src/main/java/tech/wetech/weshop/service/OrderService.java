package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.vo.OrderSubmitVO;
import tech.wetech.weshop.vo.OrderVO;

/**
 * @author cjbi
 */
public interface OrderService extends IService<Order> {

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    OrderVO queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     * @param orderSubmitVO
     * @return
     */
    Order submitOrder(OrderSubmitVO orderSubmitVO);

}
