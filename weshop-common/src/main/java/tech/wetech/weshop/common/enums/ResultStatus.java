package tech.wetech.weshop.common.enums;

/**
 * @author cjbi@outlook.com
 */
public enum ResultStatus {

    OK("200", "处理成功"),
    BAD_REQUEST("600", "请求参数有误"),
    UNAUTHORIZED("601", "未授权"),
    PARAMS_MISS("602", "缺少接口中必填参数"),
    PARAM_ERROR("603", "参数非法"),
    FAILED_DEL_OWN("604", "不能删除自己"),
    FAILED_USER_ALREADY_EXIST("605", "该用户已存在"),
    INTERNAL_SERVER_ERROR("606", "服务器内部错误"),
    NOT_IMPLEMENTED("607", "业务异常"),
    RECORD_NOT_EXIST("608", "记录不存在"),
    REMOTE_SERVICE_ERROR("609", "远程服务调用失败"),

    GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES("610", "商品已下架"),
    UNDER_STOCK("611", "库存不足"),
    PLEASE_SELECT_GOODS("612", "请选择商品"),
    PLEASE_SELECT_SHIPPING_ADDRESS("613", "请选择收货地址"),

    CREATE_ORDER_ERROR("614", "创建订单失败"),
    ;

    private String code;
    private String msg;

    ResultStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
