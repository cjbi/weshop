package tech.wetech.weshop.pay.controller;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.pay.api.WxPayApi;

/**
 * @author cjbi
 */
@Api("微信支付")
@RestController
@RequestMapping("/pay")
public class WxPayController implements WxPayApi {

  @Autowired
  private WxPayService wxService;

  @Autowired
  public WxPayController(WxPayService wxService) {
    this.wxService = wxService;
  }

  /**
   * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
   * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
   * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
   *
   * @param request 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
   */
  @Override
  public Result<WxPayUnifiedOrderResult> unifiedOrder(@RequestBody WxPayUnifiedOrderRequest request) throws WxPayException {
    return Result.success(wxService.unifiedOrder(request));
  }

}
