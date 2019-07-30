package tech.wetech.weshop.pay.api;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.pay.fallback.WxPayApiFallback;

@FeignClient(value = "weshop-user", path = "user", fallback = WxPayApiFallback.class)
public interface WxPayApi {

  /**
   * @param request
   * @return
   * @throws WxPayException
   */
  @ApiOperation(value = "原生的统一下单接口")
  @PostMapping("/unifiedOrder")
  Result<WxPayUnifiedOrderResult> unifiedOrder(@RequestBody WxPayUnifiedOrderRequest request) throws WxPayException;

}
