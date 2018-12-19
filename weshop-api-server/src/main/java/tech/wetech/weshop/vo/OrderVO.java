package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.po.OrderExpress;
import tech.wetech.weshop.po.OrderGoods;

import java.util.List;

/**
 * @author cjbi
 */
public class OrderVO {

    private Order order;

    private List<OrderGoods> orderGoods;

    private OrderExpress orderExpress;

    public OrderVO() {
    }

    public OrderVO(Order order, List<OrderGoods> orderGoods, OrderExpress orderExpress) {
        this.order = order;
        this.orderGoods = orderGoods;
        this.orderExpress = orderExpress;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderExpress getOrderExpress() {
        return orderExpress;
    }

    public void setOrderExpress(OrderExpress orderExpress) {
        this.orderExpress = orderExpress;
    }
}
