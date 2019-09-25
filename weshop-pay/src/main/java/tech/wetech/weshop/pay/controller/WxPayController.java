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
import tech.wetech.weshop.common.utils.Result;
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
  public Result<WxPayOrderQueryResult> queryOrder(String transactionId, String outTradeNo) {
    try {
        return Result.success(wxService.queryOrder(transactionId, outTradeNo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayOrderQueryResult> queryOrder(WxPayOrderQueryRequest wxPayOrderQueryRequest) {
    try {
        return Result.success(wxService.queryOrder(wxPayOrderQueryRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayOrderCloseResult> closeOrder(String outTradeNo) {
    try {
        return Result.success(wxService.closeOrder(outTradeNo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayOrderCloseResult> closeOrder(WxPayOrderCloseRequest wxPayOrderCloseRequest) {
    try {
        return Result.success(wxService.closeOrder(wxPayOrderCloseRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayUnifiedOrderResult> unifiedOrder(@RequestBody WxPayUnifiedOrderRequest request) {
    try {
        return Result.success(wxService.unifiedOrder(request));
    } catch (WxPayException e) {
      LOG.error("调用微信统一下单接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }


  @Override
  public <T> Result<T> createOrder(WxPayUnifiedOrderRequest request) {
    try {
        return Result.success(wxService.createOrder(request));
    } catch (WxPayException e) {
      LOG.error("调用统一下单接口，并组装生成支付所需参数对象失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayRefundResult> refund(WxPayRefundRequest request) {
    try {
        return Result.success(wxService.refund(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayRefundQueryResult> refundQuery(String transactionId, String outTradeNo, String outRefundNo, String refundId) {
    try {
        return Result.success(wxService.refundQuery(transactionId, outTradeNo, outRefundNo, refundId));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayRefundQueryResult> refundQuery(WxPayRefundQueryRequest wxPayRefundQueryRequest) {
    try {
        return Result.success(wxService.refundQuery(wxPayRefundQueryRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayOrderNotifyResult> parseOrderNotifyResult(String xmlData) {
    try {
        return Result.success(wxService.parseOrderNotifyResult(xmlData));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayRefundNotifyResult> parseRefundNotifyResult(String xmlData) {
    try {
        return Result.success(wxService.parseRefundNotifyResult(xmlData));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxScanPayNotifyResult> parseScanPayNotifyResult(String xmlData) {
    try {
        return Result.success(wxService.parseScanPayNotifyResult(xmlData));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPaySendRedpackResult> sendRedpack(WxPaySendRedpackRequest request) {
    try {
        return Result.success(wxService.sendRedpack(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayRedpackQueryResult> queryRedpack(String mchBillNo) {
    try {
        return Result.success(wxService.queryRedpack(mchBillNo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<byte[]> createScanPayQrcodeMode1(String productId, File logoFile, Integer sideLength) {
      return Result.success(wxService.createScanPayQrcodeMode1(productId, logoFile, sideLength));
  }

  @Override
  public Result<String> createScanPayQrcodeMode1(String productId) {
      return Result.success(wxService.createScanPayQrcodeMode1(productId));
  }

  @Override
  public Result<byte[]> createScanPayQrcodeModel(String codeUrl, File logoFile, Integer sideLength) {
      return Result.success(wxService.createScanPayQrcodeMode2(codeUrl, logoFile, sideLength));
  }

  @Override
  public Result report(WxPayReportRequest request) {
    try {
      wxService.report(request);
        return Result.success();
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayBillResult> downloadBill(String billDate, String billType, String tarType, String deviceInfo) {
    try {
        return Result.success(wxService.downloadBill(billDate, billType, tarType, deviceInfo));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayBillResult> downloadBill(WxPayDownloadBillRequest wxPayDownloadBillRequest) {
    try {
        return Result.success(wxService.downloadBill(wxPayDownloadBillRequest));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayMicropayResult> micropay(WxPayMicropayRequest request) {
    try {
        return Result.success(wxService.micropay(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayOrderReverseResult> reverseOrder(WxPayOrderReverseRequest request) {
    try {
        return Result.success(wxService.reverseOrder(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<String> getSandboxSignKey() {
    try {
        return Result.success(wxService.getSandboxSignKey());
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayCouponSendResult> sendCoupon(WxPayCouponSendRequest request) {
    try {
        return Result.success(wxService.sendCoupon(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayCouponStockQueryResult> queryCouponStock(WxPayCouponStockQueryRequest request) {
    try {
        return Result.success(wxService.queryCouponStock(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<WxPayCouponInfoQueryResult> queryCouponInfo(WxPayCouponInfoQueryRequest request) {
    try {
        return Result.success(wxService.queryCouponInfo(request));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

  @Override
  public Result<String> queryComment(Date beginDate, Date endDate, Integer offset, Integer limit) {
    try {
        return Result.success(wxService.queryComment(beginDate, endDate, offset, limit));
    } catch (WxPayException e) {
      LOG.error("调用微信支付接口失败：{}", e.getMessage(), e);
        throw new WeshopPayException(WechatPayResultStatus.WECHAT_PAY_FAIL);
    }
  }

}
