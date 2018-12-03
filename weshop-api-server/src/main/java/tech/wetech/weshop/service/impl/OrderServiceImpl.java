package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.OrderExpressMapper;
import tech.wetech.weshop.mapper.OrderGoodsMapper;
import tech.wetech.weshop.mapper.OrderMapper;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.po.OrderExpress;
import tech.wetech.weshop.po.OrderGoods;
import tech.wetech.weshop.query.OrderPageQuery;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.vo.OrderVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * @author cjbi
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private OrderExpressMapper orderExpressMapper;

    @Override
    public PageInfo<Order> queryOrderPageInfo(OrderPageQuery orderPageQuery) {

        Weekend<Order> example = Weekend.of(Order.class);
        WeekendCriteria<Order, Object> criteria = example.weekendCriteria();
        if (orderPageQuery.getId() != null) {
            criteria.andEqualTo(Order::getId, orderPageQuery.getId());
        }
        if (orderPageQuery.getUserId() != null) {
            criteria.andEqualTo(Order::getUserId, orderPageQuery.getUserId());
        }
        if (orderPageQuery.getOrderSN() != null) {
            criteria.andEqualTo(Order::getOrderSN, orderPageQuery.getOrderSN());
        }
        if (orderPageQuery.getOrderStatus() != null) {
            criteria.andEqualTo(Order::getOrderStatus, orderPageQuery.getOrderStatus());
        }
        if (orderPageQuery.getPayStatus() != null) {
            criteria.andEqualTo(Order::getPayStatus, orderPageQuery.getPayStatus());
        }

        return PageHelper.startPage(orderPageQuery.getPageNum(), orderPageQuery.getPageSize())
                .doSelectPageInfo(() -> orderMapper.selectByExample(example));
    }

    @Override
    public OrderVO queryOrderDetail(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        List<OrderGoods> orderGoodsList = orderGoodsMapper.select(new OrderGoods() {{
            setOrderId(orderId);
        }});

        OrderExpress orderExpress = orderExpressMapper.selectOne(new OrderExpress() {{
            setOrderId(orderId);
        }});

        return new OrderVO(order, orderGoodsList, orderExpress);
    }


}
