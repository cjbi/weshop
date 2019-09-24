package tech.wetech.weshop.pay.fallback;

import com.github.binarywang.wxpay.bean.coupon.*;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxScanPayNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.pay.api.WxPayApi;

import java.io.File;
import java.util.Date;

@Component
public class WxPayApiFallback implements WxPayApi {
  @Override
  public ResultWrapper<WxPayOrderQueryResult> queryOrder(String transactionId, String outTradeNo) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayOrderQueryResult> queryOrder(WxPayOrderQueryRequest wxPayOrderQueryRequest) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayOrderCloseResult> closeOrder(String outTradeNo) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayOrderCloseResult> closeOrder(WxPayOrderCloseRequest wxPayOrderCloseRequest) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayUnifiedOrderResult> unifiedOrder(WxPayUnifiedOrderRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public <T> ResultWrapper<T> createOrder(WxPayUnifiedOrderRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayRefundResult> refund(WxPayRefundRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayRefundQueryResult> refundQuery(String transactionId, String outTradeNo, String outRefundNo, String refundId) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayRefundQueryResult> refundQuery(WxPayRefundQueryRequest wxPayRefundQueryRequest) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayOrderNotifyResult> parseOrderNotifyResult(String xmlData) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayRefundNotifyResult> parseRefundNotifyResult(String xmlData) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxScanPayNotifyResult> parseScanPayNotifyResult(String xmlData) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPaySendRedpackResult> sendRedpack(WxPaySendRedpackRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayRedpackQueryResult> queryRedpack(String mchBillNo) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<byte[]> createScanPayQrcodeMode1(String productId, File logoFile, Integer sideLength) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<String> createScanPayQrcodeMode1(String productId) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<byte[]> createScanPayQrcodeModel(String codeUrl, File logoFile, Integer sideLength) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper report(WxPayReportRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayBillResult> downloadBill(String billDate, String billType, String tarType, String deviceInfo) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayBillResult> downloadBill(WxPayDownloadBillRequest wxPayDownloadBillRequest) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayMicropayResult> micropay(WxPayMicropayRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayOrderReverseResult> reverseOrder(WxPayOrderReverseRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<String> getSandboxSignKey() {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayCouponSendResult> sendCoupon(WxPayCouponSendRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayCouponStockQueryResult> queryCouponStock(WxPayCouponStockQueryRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<WxPayCouponInfoQueryResult> queryCouponInfo(WxPayCouponInfoQueryRequest request) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public ResultWrapper<String> queryComment(Date beginDate, Date endDate, Integer offset, Integer limit) {
      return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }
}
