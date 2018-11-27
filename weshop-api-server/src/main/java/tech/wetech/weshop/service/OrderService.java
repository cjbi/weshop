package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.OrderPageQuery;
import tech.wetech.weshop.vo.OrderVO;

/**
 * @author cjbi
 */
public interface OrderService {

    /**
     * 分页查询订单信息
     * @param orderPageQuery
     * @return
     */
    PageInfo<Order> queryOrderPageInfo(OrderPageQuery orderPageQuery);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    OrderVO queryOrderDetail(Integer orderId);

}
