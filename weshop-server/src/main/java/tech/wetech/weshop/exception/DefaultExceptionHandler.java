package tech.wetech.weshop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.enums.ResultCodeEnum;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author cjbi
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> handleThrowable(HttpServletRequest request, Throwable e) {
        LOGGER.error("execute methond exception error.url is {}", request.getRequestURI(), e);
        return Result.failure(e, ResultCodeEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 服务异常
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({BizException.class})
    public Result handleBizException(HttpServletRequest request, BizException e) {
        LOGGER.error("execute methond exception error.url is {}", request.getRequestURI(), e);
        return Result.failure(e);
    }

    /**
     * 参数校验异常
     * <p>使用 @Valid 注解，方法上加@RequestBody注解修饰的方法未校验通过会抛MethodArgumentNotValidException，否则抛BindException。
     * <p>使用 @Validated 注解，未校验通过会抛ConstraintViolationException
     * <p>关于 @Valid和@Validated注解的区别:
     * <p> 这两个注解都是实现JSR-303规范，不同的是@Validated是spring的注解支持groups以及可以用在spring mvc处理器的方法级别入参验证 ，@Valid是Javax提供的注解，可以支持多个bean嵌套验证。
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class, ConstraintViolationException.class})
    public Result handleNotValidException(HttpServletRequest request, Exception e) {
        LOGGER.error("execute methond exception error.url is {}", request.getRequestURI(), e);
        if (e instanceof BindException) {
            return Result.failure(((BindException) e).getBindingResult());
        }
        if (e instanceof MethodArgumentNotValidException) {
            return Result.failure(((MethodArgumentNotValidException) e).getBindingResult());
        }
        if (e instanceof ConstraintViolationException) {
            return Result.failure(ResultCodeEnum.PARAM_ERROR.getCode(), ResultCodeEnum.PARAM_ERROR.getMsg(), e.getMessage());
        }
        return Result.failure(e, ResultCodeEnum.INTERNAL_SERVER_ERROR);
    }

}
