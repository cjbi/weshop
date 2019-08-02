package tech.wetech.weshop.wechat.constants;

public class WechatConstants {

  /**
   * 服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
   */
  public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";

  /**
   * 有效期7天
   */
  public static final long JWT_TTL = 7L * 24L * 60L * 60L * 1000L;

  /**
   * Token的名字
   */
  public static final String JWT_KEY_NAME = "X-Weshop-Token";

  public static final String XML_PAY_ORDER_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";

  public static final String XML_PAY_ORDER_NOT_FOUND = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[订单不存在]]></return_msg></xml>";

  public static final String XML_PAY_ORDER_OK = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

}
