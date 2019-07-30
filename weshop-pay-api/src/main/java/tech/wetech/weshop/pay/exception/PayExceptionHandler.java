package tech.wetech.weshop.pay.exception;

import com.github.binarywang.wxpay.exception.WxPayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.exception.GlobalExceptionHandler;
import tech.wetech.weshop.common.utils.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cjbi
 */
@ControllerAdvice
public class PayExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * 微信支付调用失败的异常拦截
   *
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(WxPayException.class)
  public Result handleWxErrorException(HttpServletRequest request, WxPayException e) {
    LOG.warn("execute method exception error.url is {}", request.getRequestURI(), e);
    return Result.failure(ResultStatus.WECHAT_SERVICE_ERROR.getCode(), e.getMessage());
  }

}
