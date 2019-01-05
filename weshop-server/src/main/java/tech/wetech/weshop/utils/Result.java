package tech.wetech.weshop.utils;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;

import java.io.Serializable;
import java.util.*;

/**
 * @author cjbi
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("是否成功")
    private boolean success;

    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("消息")
    private String msg;

    @ApiModelProperty("错误消息")
    private String errorMsg;

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("额外数据")
    private Map<String, Object> extra;

    public Result<T> addExtra(String key, Object value) {
        extra = extra == null ? new HashMap<>() : extra;
        extra.put(key, value);
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public Result<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static <T> Result<T> success() {
        return Result.success(null);
    }

    public static Result failure(ResultCodeEnum resultCodeEnum) {
        return Result.failure(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
    }

    public static Result failure(ResultCodeEnum resultCodeEnum, String errorMsg) {
        return Result.failure(resultCodeEnum.getCode(), resultCodeEnum.getMsg(), errorMsg);
    }

    public static Result failure(String code, String msg) {
        return Result.failure(code, msg, null);
    }

    public static Result failure(BizException e) {
        return Result.failure(e, e.getCode(), e.getMsg(), e.getMessage());
    }

    public static Result failure(Throwable e, ResultCodeEnum resultCodeEnum) {
        return failure(e, resultCodeEnum.getCode(), resultCodeEnum.getMsg(), e.getMessage());
    }

    public static Result failure(String code, String msg, String errorMsg) {
        return failure(null, code, msg, errorMsg);
    }

    public static <T> Result<T> failure(T obj, String code, String msg) {
        return failure(obj, code, msg, null);
    }

    public static <T> Result<T> success(T obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.OK.getCode());
        result.setMsg(ResultCodeEnum.OK.getMsg());
        if (obj == null) {
            // 若数据为null 统一给前端{}
            result.setData(Collections.EMPTY_MAP);
        } else {
            result.setData(obj);
        }
        return result;
    }

    public static <T> Result<T> failure(T obj, String code, String msg, String errorMsg) {
        Result result = new Result();
        result.setData(obj);
        result.setCode(code);
        result.setSuccess(false);
        result.setMsg(msg);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public static Result failure(BindingResult br) {
        if (null != br && br.hasErrors()) {
            Map<String, String> map = new HashMap(16);
            List<FieldError> list = br.getFieldErrors();
            Iterator var3 = list.iterator();
            StringBuilder s = new StringBuilder();
            while (var3.hasNext()) {
                FieldError error = (FieldError) var3.next();
                map.put(error.getField(), error.getDefaultMessage());
                s.append(error.getField()).append(error.getDefaultMessage()).append("，");
            }
            if (s.length() > 0) {
                s.deleteCharAt(s.length() - 1);
            }
            return failure(map, ResultCodeEnum.PARAM_ERROR.getCode(), s.toString());
        } else {
            return failure(ResultCodeEnum.INTERNAL_SERVER_ERROR);
        }
    }

}
