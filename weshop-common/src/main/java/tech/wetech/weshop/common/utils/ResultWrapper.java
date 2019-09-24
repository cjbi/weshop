package tech.wetech.weshop.common.utils;

import io.swagger.annotations.ApiModelProperty;
import tech.wetech.weshop.common.enums.CommonResultStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author cjbi@outlook.com
 */
public class ResultWrapper<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("是否成功")
    private boolean success;

    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("消息")
    private String msg;

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("额外数据")
    private Map<String, Object> extra;

    private static final ResultWrapper EMPTY_SUCCESS_RESULT = ResultWrapper.success(null);

    public ResultWrapper<T> addExtraIfTrue(boolean bool, String key, Object value) {
        if (bool) {
            addExtra(key, value);
        }
        return this;
    }

    public ResultWrapper<T> addExtra(String key, Object value) {
        extra = extra == null ? new HashMap<>(16) : extra;
        extra.put(key, value);
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ResultWrapper<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ResultWrapper<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultWrapper<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultWrapper<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public ResultWrapper<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public static <T> ResultWrapper<T> success() {
        return EMPTY_SUCCESS_RESULT;
    }

    public static <T> ResultWrapper<T> success(T obj) {
        return new ResultWrapper()
            .setData(obj)
            .setCode(CommonResultStatus.OK.getCode())
            .setMsg(CommonResultStatus.OK.getMsg())
            .setSuccess(true);
    }

    public static ResultWrapper failure(ResultStatus resultStatus) {
        return new ResultWrapper()
            .setSuccess(false)
            .setCode(resultStatus.getCode())
            .setMsg(resultStatus.getMsg());
    }

    public static ResultWrapper failure(ResultStatus resultStatus, Throwable e) {
        return new ResultWrapper()
            .setSuccess(false)
            .setData(e)
            .setCode(resultStatus.getCode())
            .setMsg(resultStatus.getMsg());
    }

    public static ResultWrapper failure(String code, String msg) {
        return new ResultWrapper()
            .setSuccess(false)
            .setCode(code)
            .setMsg(msg);
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> s) throws X {
        if (this.isSuccess()) {
            return this.getData();
        } else {
            throw s.get();
        }
    }

    public T orElseGetData(Supplier<? extends T> other) {
        return this.getData() != null ? this.getData() : other.get();
    }


}
