package tech.wetech.weshop.wechat.exception;

import tech.wetech.weshop.common.exception.WeshopException;
import tech.wetech.weshop.common.utils.ResultStatus;

public class WeshopWechatException extends WeshopException {

    public WeshopWechatException(ResultStatus status) {
        super(status);
    }
}
