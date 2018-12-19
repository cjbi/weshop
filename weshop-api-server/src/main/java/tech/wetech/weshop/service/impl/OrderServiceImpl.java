package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.po.OrderExpress;
import tech.wetech.weshop.po.OrderGoods;
import tech.wetech.weshop.mapper.OrderExpressMapper;
import tech.wetech.weshop.mapper.OrderGoodsMapper;
import tech.wetech.weshop.mapper.OrderMapper;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.vo.OrderVO;

import java.util.List;

/**
 * @author cjbi
 */
@Service
public class OrderServiceImpl extends BaseService<Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private OrderExpressMapper orderExpressMapper;

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
