package tech.wetech.weshop.wechat.service;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;

public interface WechatPayService {

  /**
   * 订单预支付
   *
   * @param orderId 订单id
   * @return 微信支付订单请求参数
   */
  WxPayMpOrderResult prepay(Integer orderId);

  /**
   * 微信支付成功的通知
   *
   * @param xml 微信回调的参数
   * @return
   */
  String notify(String xml);

}
