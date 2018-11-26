package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.OrderPageQuery;

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

}
