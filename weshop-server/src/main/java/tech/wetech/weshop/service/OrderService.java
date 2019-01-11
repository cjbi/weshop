package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.OrderQuery;
import tech.wetech.weshop.vo.OrderListVO;
import tech.wetech.weshop.vo.OrderSubmitParamVO;
import tech.wetech.weshop.vo.OrderVO;

import java.util.List;

/**
 * @author cjbi
 */
public interface OrderService extends IService<Order> {

    /**
     * 分页查询订单数据
     * @param orderQuery
     * @return
     */
    List<OrderListVO> queryOrderList(OrderQuery orderQuery);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    OrderVO queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     * @param orderSubmitParamVO
     * @return
     */
    Order submitOrder(OrderSubmitParamVO orderSubmitParamVO);

}
