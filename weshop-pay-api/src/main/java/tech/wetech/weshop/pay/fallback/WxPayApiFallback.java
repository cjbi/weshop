package tech.wetech.weshop.pay.fallback;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.pay.api.WxPayApi;

@Component
public class WxPayApiFallback implements WxPayApi {
  @Override
  public Result<WxPayUnifiedOrderResult> unifiedOrder(WxPayUnifiedOrderRequest request) throws WxPayException {
    return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
  }
}
