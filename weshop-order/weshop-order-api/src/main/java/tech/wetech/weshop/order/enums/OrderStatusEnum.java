package tech.wetech.weshop.order.enums;

/**
 * @author cjbi@outlook.com
 */

public enum OrderStatusEnum {

    SUBMIT_ORDER("提交订单"),
    WAREHOUSE_DISTRIBUTION("仓库配货"),
    COMMODITY_OUT("商品出库"),
    WAITING_FOR_RECEIPT("等待收货"),
    PENDING_RETURN("待退货"),
    RETURNED("已退货"),
    COMPLETE("已完成"),
    CANCEL("已取消");

    private String name;

    OrderStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
