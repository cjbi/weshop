package tech.wetech.weshop.wechat.vo;

/**
 * @author cjbi
 */
public class PrepayResultVO {

  private String appid;
  /**
   * 时间戳，从 1970 年 1 月 1 日 00:00:00 至今的秒数，即当前的时间
   */
  private String timestamp;
  /**
   * 随机字符串，长度为32个字符以下
   */
  private String nonceStr;
  /**
   * 统一下单接口返回的 prepay_id 参数值，提交格式如：prepay_id=***
   */
  private String package_;
  /**
   * 签名算法
   */
  private String signType;
  /**
   * 签名
   */
  private String paySign;

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getPackage() {
    return package_;
  }

  public void setPackage(String package_) {
    this.package_ = package_;
  }

  public String getSignType() {
    return signType;
  }

  public void setSignType(String signType) {
    this.signType = signType;
  }

  public String getPaySign() {
    return paySign;
  }

  public void setPaySign(String paySign) {
    this.paySign = paySign;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }
}
