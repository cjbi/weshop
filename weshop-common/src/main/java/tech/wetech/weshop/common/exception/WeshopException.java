package tech.wetech.weshop.common.exception;

import tech.wetech.weshop.common.utils.ResultStatus;

public class WeshopException extends RuntimeException {

    ResultStatus status;

	public WeshopException(ResultStatus status) {
        //不生成栈追踪信息
        super(status.getMsg(), null, false, false);
        this.status = status;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }
}
