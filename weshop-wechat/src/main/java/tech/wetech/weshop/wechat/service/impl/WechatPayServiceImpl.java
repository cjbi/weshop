package tech.wetech.weshop.wechat.service.impl;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.exception.BizException;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.common.utils.StringUtils;
import tech.wetech.weshop.common.utils.WebUtil;
import tech.wetech.weshop.order.api.OrderApi;
import tech.wetech.weshop.order.enums.PayStatusEnum;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.pay.api.WxPayApi;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.service.WechatPayService;

import java.math.BigDecimal;

/**
 * @author cjbi
 */
@Service
public class WechatPayServiceImpl implements WechatPayService {

  @Autowired
  private WxPayApi wxPayApi;

  @Autowired
  private OrderApi orderApi;

  @Autowired
  private UserApi userApi;

  @Value("${weshop.wx.miniapp.appid}")
  private String appid;

  private static final Logger LOG = LoggerFactory.getLogger(WechatPayServiceImpl.class);

  @Override
  public WxPayMpOrderResult prepay(Integer orderId) {
    Order order = orderApi.queryById(orderId).getData();
    if (order == null) {
      //订单已取消
      throw new BizException(ResultStatus.ORDER_CANCELED);
    }
    if (order.getPayStatus() == PayStatusEnum.PAID) {
      throw new BizException(ResultStatus.ORDER_PAID);
    }
    String wechatOpenId = userApi.queryOneByCriteria(Criteria.of(User.class).fields(User::getWechatOpenId).andEqualTo(User::getId, order.getUserId()))
      .orElseGetData(() -> new User()).getWechatOpenId();
    //不存在openid，说明不是微信下的单
    if (StringUtils.isBlank(wechatOpenId)) {
      throw new BizException(ResultStatus.WECHAT_PAY_FAIL);
    }
    //统一下单
    WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = WxPayUnifiedOrderRequest.newBuilder()
      .openid(wechatOpenId)
      .body("订单编号：" + order.getOrderSN())
      .outTradeNo(order.getOrderSN())
      .totalFee(order.getActualPrice().multiply(new BigDecimal(100)).intValue())//订单总金额，单位为分
      .spbillCreateIp(WebUtil.getInstance().getIpAddress())
      .build();
    Result<WxPayMpOrderResult> result = wxPayApi.createOrder(wxPayUnifiedOrderRequest);
    if (!result.isSuccess()) {
      throw new BizException(ResultStatus.WECHAT_PAY_FAIL);
    }
    return result.getData();
  }

  @Override
  public String notify(String xml) {
    WxPayOrderNotifyResult wxPayOrderNotifyResult = wxPayApi.parseOrderNotifyResult(xml).getData();

    return null;
  }

}
