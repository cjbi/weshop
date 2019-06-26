package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.order.enums.OrderStatusEnum;
import tech.wetech.weshop.order.enums.PayStatusEnum;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.po.OrderGoods;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderListVO {

    private Integer id;

    private String orderSN;

    private Integer userId;

    private OrderStatusEnum orderStatus;

    private Short shippingStatus;

    private PayStatusEnum payStatus;

    private String consignee;

    private Short country;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private String mobile;

    private String postscript;

    private BigDecimal shippingFee;

    private String payName;

    private Byte payId;

    /**
     * 实际需要支付的金额
     */
    private BigDecimal actualPrice;

    private Integer integral;

    private BigDecimal integralMoney;

    /**
     * 订单总价
     */
    private BigDecimal orderPrice;

    /**
     * 商品总价
     */
    private BigDecimal goodsPrice;

    private Date createTime;

    private Date confirmTime;

    private Date payTime;

    /**
     * 配送费用
     */
    private BigDecimal freightPrice;

    /**
     * 使用的优惠券id
     */
    private Integer couponId;

    private Integer parentId;

    private BigDecimal couponPrice;

    private String callbackStatus;

    /**
     * 商品统计
     */
    private Integer goodsCount;

    private List<OrderGoods> goodsList;

    /**
     * 订单状态的处理
     */
    private String orderStatusText;

    private HandleOptionVO handleOption;

    public OrderListVO() {
    }

    public OrderListVO(Order order) {
        this.id = order.getId();
        this.orderSN = order.getOrderSN();
        this.userId = order.getUserId();
        this.orderStatus = order.getOrderStatus();
        this.shippingStatus = order.getShippingStatus();
        this.payStatus = order.getPayStatus();
        this.consignee = order.getConsignee();
        this.country = order.getCountry();
        this.province = order.getProvince();
        this.city = order.getCity();
        this.district = order.getDistrict();
        this.address = order.getAddress();
        this.mobile = order.getMobile();
        this.postscript = order.getPostscript();
        this.shippingFee = order.getShippingFee();
        this.payName = order.getPayName();
        this.payId = order.getPayId();
        this.actualPrice = order.getActualPrice();
        this.integral = order.getIntegral();
        this.integralMoney = order.getIntegralMoney();
        this.orderPrice = order.getOrderPrice();
        this.goodsPrice = order.getGoodsPrice();
        this.createTime = order.getCreateTime();
        this.confirmTime = order.getConfirmTime();
        this.payTime = order.getPayTime();
        this.freightPrice = order.getFreightPrice();
        this.couponId = order.getCouponId();
        this.parentId = order.getParentId();
        this.couponPrice = order.getCouponPrice();
        this.callbackStatus = order.getCallbackStatus();
        this.goodsCount = null;
        this.orderStatusText = null;
    }

    public Integer getId() {
        return id;
    }

    public OrderListVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOrderSN() {
        return orderSN;
    }

    public OrderListVO setOrderSN(String orderSN) {
        this.orderSN = orderSN;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public OrderListVO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public OrderListVO setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Short getShippingStatus() {
        return shippingStatus;
    }

    public OrderListVO setShippingStatus(Short shippingStatus) {
        this.shippingStatus = shippingStatus;
        return this;
    }

    public PayStatusEnum getPayStatus() {
        return payStatus;
    }

    public OrderListVO setPayStatus(PayStatusEnum payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public String getConsignee() {
        return consignee;
    }

    public OrderListVO setConsignee(String consignee) {
        this.consignee = consignee;
        return this;
    }

    public Short getCountry() {
        return country;
    }

    public OrderListVO setCountry(Short country) {
        this.country = country;
        return this;
    }

    public Short getProvince() {
        return province;
    }

    public OrderListVO setProvince(Short province) {
        this.province = province;
        return this;
    }

    public Short getCity() {
        return city;
    }

    public OrderListVO setCity(Short city) {
        this.city = city;
        return this;
    }

    public Short getDistrict() {
        return district;
    }

    public OrderListVO setDistrict(Short district) {
        this.district = district;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderListVO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public OrderListVO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPostscript() {
        return postscript;
    }

    public OrderListVO setPostscript(String postscript) {
        this.postscript = postscript;
        return this;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public OrderListVO setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
        return this;
    }

    public String getPayName() {
        return payName;
    }

    public OrderListVO setPayName(String payName) {
        this.payName = payName;
        return this;
    }

    public Byte getPayId() {
        return payId;
    }

    public OrderListVO setPayId(Byte payId) {
        this.payId = payId;
        return this;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public OrderListVO setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
        return this;
    }

    public Integer getIntegral() {
        return integral;
    }

    public OrderListVO setIntegral(Integer integral) {
        this.integral = integral;
        return this;
    }

    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }

    public OrderListVO setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
        return this;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public OrderListVO setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public OrderListVO setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrderListVO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public OrderListVO setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
        return this;
    }

    public Date getPayTime() {
        return payTime;
    }

    public OrderListVO setPayTime(Date payTime) {
        this.payTime = payTime;
        return this;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public OrderListVO setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
        return this;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public OrderListVO setCouponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public OrderListVO setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public OrderListVO setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
        return this;
    }

    public String getCallbackStatus() {
        return callbackStatus;
    }

    public OrderListVO setCallbackStatus(String callbackStatus) {
        this.callbackStatus = callbackStatus;
        return this;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public OrderListVO setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
        return this;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public OrderListVO setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
        return this;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public OrderListVO setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
        return this;
    }

    public HandleOptionVO getHandleOption() {
        return handleOption;
    }

    public OrderListVO setHandleOption(HandleOptionVO handleOption) {
        this.handleOption = handleOption;
        return this;
    }
}
