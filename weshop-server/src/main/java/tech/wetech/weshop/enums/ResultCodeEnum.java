package tech.wetech.weshop.enums;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {

    OK("200", "处理成功"),
    BAD_REQUEST("400", "请求参数有误"),
    UNAUTHORIZED("401", "未授权"),
    PARAMS_MISS("483", "缺少接口中必填参数"),
    PARAM_ERROR("484", "参数非法"),
    FAILED_DEL_OWN("485", "不能删除自己"),
    FAILED_USER_ALREADY_EXIST("486", "该用户已存在"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    NOT_IMPLEMENTED("501", "业务异常"),

    GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES("600", "商品已下架"),
    UNDER_STOCK("601", "库存不足"),
    PLEASE_SELECT_GOODS("602","请选择商品"),
    PLEASE_SELECT_SHIPPING_ADDRESS("603","请选择收货地址")
    ;
    private String code;
    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
