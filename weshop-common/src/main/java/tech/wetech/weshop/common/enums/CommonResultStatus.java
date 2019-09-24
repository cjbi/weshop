package tech.wetech.weshop.common.enums;

import tech.wetech.weshop.common.utils.ResultStatus;

/**
 * @author cjbi@outlook.com
 */
public enum CommonResultStatus implements ResultStatus {

    OK("200", "处理成功"),
    PARAM_ERROR("603", "参数非法"),
    INTERNAL_SERVER_ERROR("606", "服务器内部错误"),
    RECORD_NOT_EXIST("608", "记录不存在"),
    REMOTE_SERVICE_ERROR("609", "远程服务调用失败"),

//    GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES("610", "商品已下架"),
//    UNDER_STOCK("611", "库存不足"),
//    PLEASE_SELECT_GOODS("612", "请选择商品"),
//    PLEASE_SELECT_SHIPPING_ADDRESS("613", "请选择收货地址"),

//    CREATE_ORDER_ERROR("614", "创建订单失败"),
//    WECHAT_SERVICE_ERROR("615", "微信服务调用失败"),
//    WECHAT_LOGIN_ERROR("616", "请先登陆"),
//    ORDER_CANCELED("618", "订单已取消"),
//    ORDER_PAID("619", "订单已支付，请不要重复操作"),
//    WECHAT_PAY_FAIL("620", "微信支付失败"),
    ;

    private String code;
    private String msg;

    CommonResultStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
