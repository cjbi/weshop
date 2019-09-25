package tech.wetech.weshop.wechat.controller;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
  public Result<WxPayMpOrderResult> prepay(@NotNull @RequestParam("orderId") Integer orderId, @RequestParam("payType") Integer payType) {
      return Result.success(wechatPayService.prepay(orderId));
  }

  /**
   * 当支付成功后微信会回调这个地址，在这里你可以做一些事，比如修改订单状态什么的。
   *
   * @param xml
   * @return
   */
  @PostMapping("/notify")
  @ApiOperation("当支付成功后微信会回调这个地址，在这里你可以做一些事，比如修改订单状态什么的。")
  public String notify(String xml) {
    return null;
  }

}
