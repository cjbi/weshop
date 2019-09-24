package tech.wetech.weshop.pay.controller;

import com.github.binarywang.wxpay.bean.coupon.*;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxScanPayNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.pay.api.WxPayApi;
import tech.wetech.weshop.pay.enums.WechatPayResultStatus;
import tech.wetech.weshop.pay.exception.WeshopPayException;

import java.io.File;
import java.util.Date;

/**
 * @author cjbi
 */
@Api("微信支付")
@RestController
@RequestMapping("/pay")
public class WxPayController implements WxPayApi {

  private static final Logger LOG = LoggerFactory.getLogger(WxPayController.class);

  @Autowired
  private WxPayService wxService;

  @Autowired
  public WxPayController(WxPayService wxService) {
    this.wxService = wxService;
  }

  @Override
  public ResultWrapper<WxPayOrderQueryResult> queryOrder(String transactionId, String outTradeNo) {
    try {
        return ResultWrapper.success(wxService.queryOrder(transactionId, outTradeNo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayOrderQueryResult> queryOrder(WxPayOrderQueryRequest wxPayOrderQueryRequest) {
    try {
        return ResultWrapper.success(wxService.queryOrder(wxPayOrderQueryRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayOrderCloseResult> closeOrder(String outTradeNo) {
    try {
        return ResultWrapper.success(wxService.closeOrder(outTradeNo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayOrderCloseResult> closeOrder(WxPayOrderCloseRequest wxPayOrderCloseRequest) {
    try {
        return ResultWrapper.success(wxService.closeOrder(wxPayOrderCloseRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayUnifiedOrderResult> unifiedOrder(@RequestBody WxPayUnifiedOrderRequest request) {
    try {
        return ResultWrapper.success(wxService.unifiedOrder(request));
    } catch (WxPayException e) {
      LOG.error("调用微信统一下单接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }


  @Override
  public <T> ResultWrapper<T> createOrder(WxPayUnifiedOrderRequest request) {
    try {
        return ResultWrapper.success(wxService.createOrder(request));
    } catch (WxPayException e) {
      LOG.error("调用统一下单接口，并组装生成支付所需参数对象失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayRefundResult> refund(WxPayRefundRequest request) {
    try {
        return ResultWrapper.success(wxService.refund(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayRefundQueryResult> refundQuery(String transactionId, String outTradeNo, String outRefundNo, String refundId) {
    try {
        return ResultWrapper.success(wxService.refundQuery(transactionId, outTradeNo, outRefundNo, refundId));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayRefundQueryResult> refundQuery(WxPayRefundQueryRequest wxPayRefundQueryRequest) {
    try {
        return ResultWrapper.success(wxService.refundQuery(wxPayRefundQueryRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayOrderNotifyResult> parseOrderNotifyResult(String xmlData) {
    try {
        return ResultWrapper.success(wxService.parseOrderNotifyResult(xmlData));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayRefundNotifyResult> parseRefundNotifyResult(String xmlData) {
    try {
        return ResultWrapper.success(wxService.parseRefundNotifyResult(xmlData));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxScanPayNotifyResult> parseScanPayNotifyResult(String xmlData) {
    try {
        return ResultWrapper.success(wxService.parseScanPayNotifyResult(xmlData));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPaySendRedpackResult> sendRedpack(WxPaySendRedpackRequest request) {
    try {
        return ResultWrapper.success(wxService.sendRedpack(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayRedpackQueryResult> queryRedpack(String mchBillNo) {
    try {
        return ResultWrapper.success(wxService.queryRedpack(mchBillNo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<byte[]> createScanPayQrcodeMode1(String productId, File logoFile, Integer sideLength) {
      return ResultWrapper.success(wxService.createScanPayQrcodeMode1(productId, logoFile, sideLength));
  }

  @Override
  public ResultWrapper<String> createScanPayQrcodeMode1(String productId) {
      return ResultWrapper.success(wxService.createScanPayQrcodeMode1(productId));
  }

  @Override
  public ResultWrapper<byte[]> createScanPayQrcodeModel(String codeUrl, File logoFile, Integer sideLength) {
      return ResultWrapper.success(wxService.createScanPayQrcodeMode2(codeUrl, logoFile, sideLength));
  }

  @Override
  public ResultWrapper report(WxPayReportRequest request) {
    try {
      wxService.report(request);
        return ResultWrapper.success();
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayBillResult> downloadBill(String billDate, String billType, String tarType, String deviceInfo) {
    try {
        return ResultWrapper.success(wxService.downloadBill(billDate, billType, tarType, deviceInfo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayBillResult> downloadBill(WxPayDownloadBillRequest wxPayDownloadBillRequest) {
    try {
        return ResultWrapper.success(wxService.downloadBill(wxPayDownloadBillRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayMicropayResult> micropay(WxPayMicropayRequest request) {
    try {
        return ResultWrapper.success(wxService.micropay(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayOrderReverseResult> reverseOrder(WxPayOrderReverseRequest request) {
    try {
        return ResultWrapper.success(wxService.reverseOrder(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<String> getSandboxSignKey() {
    try {
        return ResultWrapper.success(wxService.getSandboxSignKey());
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayCouponSendResult> sendCoupon(WxPayCouponSendRequest request) {
    try {
        return ResultWrapper.success(wxService.sendCoupon(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayCouponStockQueryResult> queryCouponStock(WxPayCouponStockQueryRequest request) {
    try {
        return ResultWrapper.success(wxService.queryCouponStock(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<WxPayCouponInfoQueryResult> queryCouponInfo(WxPayCouponInfoQueryRequest request) {
    try {
        return ResultWrapper.success(wxService.queryCouponInfo(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public ResultWrapper<String> queryComment(Date beginDate, Date endDate, Integer offset, Integer limit) {
    try {
        return ResultWrapper.success(wxService.queryComment(beginDate, endDate, offset, limit));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

}
