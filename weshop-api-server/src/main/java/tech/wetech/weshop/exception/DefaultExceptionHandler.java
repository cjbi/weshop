package tech.wetech.weshop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
     * 方法上加`@RequstBody`注解修饰的方法未校验通过会抛MethodArgumentNotValidException，否则抛BindException。
     * 类上加`@Validated`这个注解未校验通过会抛ConstraintViolationException
     *
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
