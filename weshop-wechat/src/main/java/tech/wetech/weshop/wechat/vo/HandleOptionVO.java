package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.order.enums.OrderStatusEnum;
import tech.wetech.weshop.order.enums.PayStatusEnum;
import tech.wetech.weshop.order.po.Order;


/**
 * // 订单流程：下单成功－》支付订单－》发货－》收货－》评论
 * // 订单相关状态字段设计，采用单个字段表示全部的订单状态
 * // 1xx表示订单取消和删除等状态 0订单创建成功等待付款，101订单已取消，102订单已删除
 * // 2xx表示订单支付状态,201订单已付款，等待发货
 * // 3xx表示订单物流相关状态,300订单已发货，301用户确认收货
 * // 4xx表示订单退换货相关的状态,401没有发货，退款402,已收货，退款退货
 * // 如果订单已经取消或是已完成，则可删除和再次购买
 * 获取订单可操作的选项
 */
public class HandleOptionVO {
    /**
     * 支付操作
     */
    private boolean buy;
    /**
     * 取消操作
     */
    private boolean cancel;
    /**
     * 评论操作
     */
    private boolean comment;
    /**
     * 完成订单操作
     */
    private boolean confirm;
    /**
     * 删除操作
     */
    private boolean delete;
    /**
     * 确认收货操作
     */
    private boolean delivery;
    /**
     * 支付操作
     */
    private boolean pay;
    /**
     * 退换货操作
     */
    private boolean isReturn;

    public HandleOptionVO() {
    }

    public HandleOptionVO(Order order) {
        OrderStatusEnum orderStatus = order.getOrderStatus();
        PayStatusEnum payStatus = order.getPayStatus();
        // 如果订单已经取消或是已完成，则可删除和再次购买
        if (orderStatus == OrderStatusEnum.COMPLETE || orderStatus == OrderStatusEnum.CANCEL) {
            delete = true;
            buy = true;
        }
        // 如果订单没有被取消，且没有支付，则可支付，可取消
        if (orderStatus == OrderStatusEnum.SUBMIT_ORDER && payStatus == PayStatusEnum.PENDING_PAYMENT) {
            cancel = true;
            pay = true;
        }
        // 如果订单已付款，没有发货，则可退款操作
        if (payStatus == PayStatusEnum.PAID && (orderStatus == OrderStatusEnum.SUBMIT_ORDER || orderStatus == OrderStatusEnum.WAREHOUSE_DISTRIBUTION || orderStatus == OrderStatusEnum.COMMODITY_OUT)) {
            isReturn = true;
        }
        // 如果订单已经支付，且已经收货，则可完成交易、评论和再次购买
        if (payStatus == PayStatusEnum.PAID && orderStatus == OrderStatusEnum.WAITING_FOR_RECEIPT) {
            cancel = true;
            pay = true;
            isReturn = true;
        }
    }

    public boolean isBuy() {
        return buy;
    }

    public HandleOptionVO setBuy(boolean buy) {
        this.buy = buy;
        return this;
    }

    public boolean isCancel() {
        return cancel;
    }

    public HandleOptionVO setCancel(boolean cancel) {
        this.cancel = cancel;
        return this;
    }

    public boolean isComment() {
        return comment;
    }

    public HandleOptionVO setComment(boolean comment) {
        this.comment = comment;
        return this;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public HandleOptionVO setConfirm(boolean confirm) {
        this.confirm = confirm;
        return this;
    }

    public boolean isDelete() {
        return delete;
    }

    public HandleOptionVO setDelete(boolean delete) {
        this.delete = delete;
        return this;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public HandleOptionVO setDelivery(boolean delivery) {
        this.delivery = delivery;
        return this;
    }

    public boolean isPay() {
        return pay;
    }

    public HandleOptionVO setPay(boolean pay) {
        this.pay = pay;
        return this;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public HandleOptionVO setReturn(boolean aReturn) {
        isReturn = aReturn;
        return this;
    }
}
