package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.po.OrderExpress;
import tech.wetech.weshop.po.OrderGoods;

import java.util.List;

/**
 * @author cjbi
 */
public class OrderVO {

    private Order orderInfo;

    private List<OrderGoods> orderGoods;

    private OrderExpress orderExpress;

    private HandleOptionVO handleOption;

    public OrderVO() {
    }

    public OrderVO(Order order, List<OrderGoods> orderGoods, OrderExpress orderExpress, HandleOptionVO handleOption) {
        this.orderInfo = order;
        this.orderGoods = orderGoods;
        this.orderExpress = orderExpress;
        this.handleOption = handleOption;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Order getOrderInfo() {
        return orderInfo;
    }

    public OrderVO setOrderInfo(Order orderInfo) {
        this.orderInfo = orderInfo;
        return this;
    }

    public OrderExpress getOrderExpress() {
        return orderExpress;
    }

    public void setOrderExpress(OrderExpress orderExpress) {
        this.orderExpress = orderExpress;
    }

    public HandleOptionVO getHandleOption() {
        return handleOption;
    }

    public OrderVO setHandleOption(HandleOptionVO handleOption) {
        this.handleOption = handleOption;
        return this;
    }
}
