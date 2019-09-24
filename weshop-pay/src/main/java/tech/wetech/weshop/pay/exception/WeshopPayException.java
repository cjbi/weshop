package tech.wetech.weshop.pay.exception;

import tech.wetech.weshop.common.exception.WeshopException;
import tech.wetech.weshop.common.utils.ResultStatus;

public class WeshopPayException extends WeshopException {

    public WeshopPayException(ResultStatus status) {
        super(status);
    }
}
