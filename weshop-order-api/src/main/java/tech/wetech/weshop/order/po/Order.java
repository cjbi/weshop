package tech.wetech.weshop.order.po;

import tech.wetech.weshop.order.enums.OrderStatusEnum;
import tech.wetech.weshop.order.enums.PayStatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "weshop_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_sn")
    private String orderSN;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "order_status")
    private OrderStatusEnum orderStatus;

    @Column(name = "shipping_status")
    private Short shippingStatus;

    @Column(name = "pay_status")
    private PayStatusEnum payStatus;

    private String consignee;

    private Short country;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private String mobile;

    private String postscript;

    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;

    @Column(name = "pay_name")
    private String payName;

    @Column(name = "pay_id")
    private Byte payId;

    /**
     * 实际需要支付的金额
     */
    @Column(name = "actual_price")
    private BigDecimal actualPrice;

    private Integer integral;

    @Column(name = "integral_money")
    private BigDecimal integralMoney;

    /**
     * 订单总价
     */
    @Column(name = "order_price")
    private BigDecimal orderPrice;

    /**
     * 商品总价
     */
    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "confirm_time")
    private Date confirmTime;

    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 配送费用
     */
    @Column(name = "freight_price")
    private BigDecimal freightPrice;

    /**
     * 使用的优惠券id
     */
    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "coupon_price")
    private BigDecimal couponPrice;

    @Column(name = "callback_status")
    private String callbackStatus;

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOrderSN() {
        return orderSN;
    }

    public Order setOrderSN(String orderSN) {
        this.orderSN = orderSN;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Order setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Short getShippingStatus() {
        return shippingStatus;
    }

    public Order setShippingStatus(Short shippingStatus) {
        this.shippingStatus = shippingStatus;
        return this;
    }

    public PayStatusEnum getPayStatus() {
        return payStatus;
    }

    public Order setPayStatus(PayStatusEnum payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public String getConsignee() {
        return consignee;
    }

    public Order setConsignee(String consignee) {
        this.consignee = consignee;
        return this;
    }

    public Short getCountry() {
        return country;
    }

    public Order setCountry(Short country) {
        this.country = country;
        return this;
    }

    public Short getProvince() {
        return province;
    }

    public Order setProvince(Short province) {
        this.province = province;
        return this;
    }

    public Short getCity() {
        return city;
    }

    public Order setCity(Short city) {
        this.city = city;
        return this;
    }

    public Short getDistrict() {
        return district;
    }

    public Order setDistrict(Short district) {
        this.district = district;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Order setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPostscript() {
        return postscript;
    }

    public Order setPostscript(String postscript) {
        this.postscript = postscript;
        return this;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public Order setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
        return this;
    }

    public String getPayName() {
        return payName;
    }

    public Order setPayName(String payName) {
        this.payName = payName;
        return this;
    }

    public Byte getPayId() {
        return payId;
    }

    public Order setPayId(Byte payId) {
        this.payId = payId;
        return this;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public Order setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
        return this;
    }

    public Integer getIntegral() {
        return integral;
    }

    public Order setIntegral(Integer integral) {
        this.integral = integral;
        return this;
    }

    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }

    public Order setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
        return this;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public Order setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public Order setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Order setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public Order setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
        return this;
    }

    public Date getPayTime() {
        return payTime;
    }

    public Order setPayTime(Date payTime) {
        this.payTime = payTime;
        return this;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public Order setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
        return this;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public Order setCouponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Order setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public Order setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
        return this;
    }

    public String getCallbackStatus() {
        return callbackStatus;
    }

    public Order setCallbackStatus(String callbackStatus) {
        this.callbackStatus = callbackStatus;
        return this;
    }
}