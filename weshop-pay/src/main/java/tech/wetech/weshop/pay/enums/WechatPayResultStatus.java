package tech.wetech.weshop.pay.enums;

import tech.wetech.weshop.common.utils.ResultStatus;

public enum WechatPayResultStatus implements ResultStatus {
    WECHAT_PAY_FAIL("620", "微信支付失败"),
    ;

    private String code;
    private String msg;

    WechatPayResultStatus(String code, String msg) {
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
