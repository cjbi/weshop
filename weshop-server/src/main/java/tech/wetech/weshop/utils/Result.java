package tech.wetech.weshop.utils;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

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

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("额外数据")
    private Map<String, Object> extra;

    public Result<T> addExtra(String key, Object value) {
        extra = extra == null ? new HashMap<>(16) : extra;
        extra.put(key, value);
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public Result<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public static <T> Result<T> success() {
        //统一给前端{}
        return Result.success((T) Collections.EMPTY_MAP);
    }

    public static Result failure(Throwable e, ResultCodeEnum resultCodeEnum) {
        Result result = new Result()
                .setSuccess(false)
                .setCode(resultCodeEnum.getCode())
                .setMsg(resultCodeEnum.getMsg())
                .addExtra("stackTrace",e.getStackTrace())
                .addExtra("exceptionMessage",e.getClass().getName() + ": " + e.getMessage());
        if (e instanceof BizException) {
            return result.setMsg(((BizException) e).getMsg())
                    .setCode(((BizException) e).getCode());
        }
        BindingResult br = null;
        if (e instanceof BindException) {
            br = ((BindException) e).getBindingResult();
        }
        if (e instanceof MethodArgumentNotValidException) {
            br = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        if (br != null) {
            return result.setData(
                    br.getFieldErrors().stream()
                            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (oldValue, newValue) -> oldValue.concat(",").concat(newValue)))
            ).setMsg(
                    br.getFieldErrors().stream()
                            .map(f -> f.getField().concat(f.getDefaultMessage()))
                            .collect(Collectors.joining(","))
            );
        }
        if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            return result
                    .setData(
                            constraintViolations.stream().collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage))
                    )
                    .setMsg(e.getMessage());
        }
        return result;
    }

    public static <T> Result<T> success(T obj) {
        return new Result()
                .setCode(ResultCodeEnum.OK.getCode())
                .setMsg(ResultCodeEnum.OK.getMsg())
                .setData(obj);
    }

}
