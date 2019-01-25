package tech.wetech.weshop.admin.dto;

import tech.wetech.weshop.enums.OrderStatusEnum;
import tech.wetech.weshop.enums.PayStatusEnum;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.po.OrderGoods;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderListDTO {

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

    private HandleOptionDTO handleOption;

    public OrderListDTO(Order order) {
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

    public OrderListDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOrderSN() {
        return orderSN;
    }

    public OrderListDTO setOrderSN(String orderSN) {
        this.orderSN = orderSN;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public OrderListDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public OrderListDTO setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Short getShippingStatus() {
        return shippingStatus;
    }

    public OrderListDTO setShippingStatus(Short shippingStatus) {
        this.shippingStatus = shippingStatus;
        return this;
    }

    public PayStatusEnum getPayStatus() {
        return payStatus;
    }

    public OrderListDTO setPayStatus(PayStatusEnum payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public String getConsignee() {
        return consignee;
    }

    public OrderListDTO setConsignee(String consignee) {
        this.consignee = consignee;
        return this;
    }

    public Short getCountry() {
        return country;
    }

    public OrderListDTO setCountry(Short country) {
        this.country = country;
        return this;
    }

    public Short getProvince() {
        return province;
    }

    public OrderListDTO setProvince(Short province) {
        this.province = province;
        return this;
    }

    public Short getCity() {
        return city;
    }

    public OrderListDTO setCity(Short city) {
        this.city = city;
        return this;
    }

    public Short getDistrict() {
        return district;
    }

    public OrderListDTO setDistrict(Short district) {
        this.district = district;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderListDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public OrderListDTO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPostscript() {
        return postscript;
    }

    public OrderListDTO setPostscript(String postscript) {
        this.postscript = postscript;
        return this;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public OrderListDTO setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
        return this;
    }

    public String getPayName() {
        return payName;
    }

    public OrderListDTO setPayName(String payName) {
        this.payName = payName;
        return this;
    }

    public Byte getPayId() {
        return payId;
    }

    public OrderListDTO setPayId(Byte payId) {
        this.payId = payId;
        return this;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public OrderListDTO setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
        return this;
    }

    public Integer getIntegral() {
        return integral;
    }

    public OrderListDTO setIntegral(Integer integral) {
        this.integral = integral;
        return this;
    }

    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }

    public OrderListDTO setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
        return this;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public OrderListDTO setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public OrderListDTO setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrderListDTO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public OrderListDTO setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
        return this;
    }

    public Date getPayTime() {
        return payTime;
    }

    public OrderListDTO setPayTime(Date payTime) {
        this.payTime = payTime;
        return this;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public OrderListDTO setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
        return this;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public OrderListDTO setCouponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public OrderListDTO setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public OrderListDTO setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
        return this;
    }

    public String getCallbackStatus() {
        return callbackStatus;
    }

    public OrderListDTO setCallbackStatus(String callbackStatus) {
        this.callbackStatus = callbackStatus;
        return this;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public OrderListDTO setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
        return this;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public OrderListDTO setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
        return this;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public OrderListDTO setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
        return this;
    }

    public HandleOptionDTO getHandleOption() {
        return handleOption;
    }

    public OrderListDTO setHandleOption(HandleOptionDTO handleOption) {
        this.handleOption = handleOption;
        return this;
    }
}
