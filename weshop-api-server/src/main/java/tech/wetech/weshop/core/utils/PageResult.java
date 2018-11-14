package tech.wetech.weshop.core.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tech.wetech.weshop.core.exception.BizException;

import java.util.ArrayList;

/**
 * 通用分页返回结果集
 *
 * @author cjbi
 */
@ApiModel("分页返回结果")
public class PageResult<T> extends Result<T> {

    /**
     * 总数
     */
    @ApiModelProperty("总数")
    private Integer total;

    public PageResult() {
        super();
    }

    public static <T> PageResult<T> success() {
        return success(null, null);
    }

    public static <T> PageResult<T> success(T obj) {
        return success(null, obj);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static <T> PageResult<T> success(Integer total, T obj) {
        PageResult<T> pageResult = new PageResult();
        pageResult.setSuccess(true);
        pageResult.setCode(ResultCodeEnum.OK.getCode());
        pageResult.setMsg(ResultCodeEnum.OK.getMsg());
        if (obj == null) {
            // 若返回数据为null 统一返回给前端[]
            pageResult.setData((T) new ArrayList());
        } else {
            pageResult.setTotal(total);
            pageResult.setData(obj);
        }
        return pageResult;
    }

    public static PageResult failure(String code, String msg) {
        return PageResult.failure(code, msg, null);
    }

    public static PageResult failure(BizException e) {
        return PageResult.failure(e, e.getCode(), e.getMsg(), e.getMessage());
    }

    public static PageResult failure(Throwable e, ResultCodeEnum resultCodeEnum) {
        return failure(e, resultCodeEnum.getCode(), resultCodeEnum.getMsg(), e.getMessage());
    }

    public static PageResult failure(String code, String msg, String errorMsg) {
        return failure(null, code, msg, errorMsg);
    }

    public static <T> PageResult<T> failure(T obj, String code, String msg) {
        return failure(obj, code, msg, null);
    }

    public static <T> PageResult<T> failure(T obj, String code, String msg, String errorMsg) {
        PageResult result = new PageResult();
        result.setData(obj);
        result.setCode(code);
        result.setSuccess(false);
        result.setMsg(msg);
        result.setErrorMsg(errorMsg);
        return result;
    }

}
