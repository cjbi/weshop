package tech.wetech.weshop.wechat.controller;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.wechat.service.WechatPayService;

import javax.validation.constraints.NotNull;

/**
 * 微信支付
 *
 * @author cjbi
 */
@RestController
@RequestMapping("/pay")
@Validated
public class WechatPayController {

  @Autowired
  private WechatPayService wechatPayService;

  @GetMapping("/prepay")
  public Result<WxPayMpOrderResult> prepay(@NotNull @RequestParam("orderId") Integer orderId) {
    return Result.success(wechatPayService.prepay(orderId));
  }

}
