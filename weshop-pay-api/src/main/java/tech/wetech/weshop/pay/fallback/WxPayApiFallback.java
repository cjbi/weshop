package tech.wetech.weshop.pay.fallback;

import com.github.binarywang.wxpay.bean.coupon.*;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxScanPayNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.pay.api.WxPayApi;

import java.io.File;
import java.util.Date;

@Component
public class WxPayApiFallback implements WxPayApi {
  @Override
  public Result<WxPayOrderQueryResult> queryOrder(String transactionId, String outTradeNo) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayOrderQueryResult> queryOrder(WxPayOrderQueryRequest wxPayOrderQueryRequest) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayOrderCloseResult> closeOrder(String outTradeNo) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayOrderCloseResult> closeOrder(WxPayOrderCloseRequest wxPayOrderCloseRequest) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayUnifiedOrderResult> unifiedOrder(WxPayUnifiedOrderRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public <T> Result<T> createOrder(WxPayUnifiedOrderRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayRefundResult> refund(WxPayRefundRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayRefundQueryResult> refundQuery(String transactionId, String outTradeNo, String outRefundNo, String refundId) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayRefundQueryResult> refundQuery(WxPayRefundQueryRequest wxPayRefundQueryRequest) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayOrderNotifyResult> parseOrderNotifyResult(String xmlData) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayRefundNotifyResult> parseRefundNotifyResult(String xmlData) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxScanPayNotifyResult> parseScanPayNotifyResult(String xmlData) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPaySendRedpackResult> sendRedpack(WxPaySendRedpackRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayRedpackQueryResult> queryRedpack(String mchBillNo) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<byte[]> createScanPayQrcodeMode1(String productId, File logoFile, Integer sideLength) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<String> createScanPayQrcodeMode1(String productId) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<byte[]> createScanPayQrcodeModel(String codeUrl, File logoFile, Integer sideLength) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result report(WxPayReportRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayBillResult> downloadBill(String billDate, String billType, String tarType, String deviceInfo) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayBillResult> downloadBill(WxPayDownloadBillRequest wxPayDownloadBillRequest) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayMicropayResult> micropay(WxPayMicropayRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayOrderReverseResult> reverseOrder(WxPayOrderReverseRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<String> getSandboxSignKey() {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayCouponSendResult> sendCoupon(WxPayCouponSendRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayCouponStockQueryResult> queryCouponStock(WxPayCouponStockQueryRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<WxPayCouponInfoQueryResult> queryCouponInfo(WxPayCouponInfoQueryRequest request) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }

  @Override
  public Result<String> queryComment(Date beginDate, Date endDate, Integer offset, Integer limit) {
      return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
  }
}
