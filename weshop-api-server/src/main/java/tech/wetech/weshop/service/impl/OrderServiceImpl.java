package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.OrderPageQuery;
import tech.wetech.weshop.service.OrderService;

/**
 * @author cjbi
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public PageInfo<Order> queryOrderPageInfo(OrderPageQuery orderPageQuery) {
        return null;
    }
}
