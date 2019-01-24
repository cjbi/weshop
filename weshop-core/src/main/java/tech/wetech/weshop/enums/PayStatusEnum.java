package tech.wetech.weshop.enums;

/**
 * @author cjbi
 */

public enum PayStatusEnum {

    CASH_ON_DELIVERY("到付"),
    PENDING_PAYMENT("待付款"),
    PAID("已付款"),
    PENDING_REFUND("待退款"),
    REFUND_SUCCESSFULLY("退款成功"),
    REFUND_FAILED("退款失败");

    private String name;

    PayStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
