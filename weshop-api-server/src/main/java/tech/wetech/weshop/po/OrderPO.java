package tech.wetech.weshop.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "weshop_order")
public class OrderPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_sn")
    private String orderSn;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "order_status")
    private Boolean orderStatus;

    @Column(name = "shipping_status")
    private Boolean shippingStatus;

    @Column(name = "pay_status")
    private Boolean payStatus;

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
    private Integer freightPrice;

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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return order_sn
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * @param orderSn
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return order_status
     */
    public Boolean getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus
     */
    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return shipping_status
     */
    public Boolean getShippingStatus() {
        return shippingStatus;
    }

    /**
     * @param shippingStatus
     */
    public void setShippingStatus(Boolean shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    /**
     * @return pay_status
     */
    public Boolean getPayStatus() {
        return payStatus;
    }

    /**
     * @param payStatus
     */
    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * @return consignee
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * @param consignee
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * @return country
     */
    public Short getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(Short country) {
        this.country = country;
    }

    /**
     * @return province
     */
    public Short getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(Short province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public Short getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(Short city) {
        this.city = city;
    }

    /**
     * @return district
     */
    public Short getDistrict() {
        return district;
    }

    /**
     * @param district
     */
    public void setDistrict(Short district) {
        this.district = district;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return postscript
     */
    public String getPostscript() {
        return postscript;
    }

    /**
     * @param postscript
     */
    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    /**
     * @return shipping_fee
     */
    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    /**
     * @param shippingFee
     */
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     * @return pay_name
     */
    public String getPayName() {
        return payName;
    }

    /**
     * @param payName
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }

    /**
     * @return pay_id
     */
    public Byte getPayId() {
        return payId;
    }

    /**
     * @param payId
     */
    public void setPayId(Byte payId) {
        this.payId = payId;
    }

    /**
     * 获取实际需要支付的金额
     *
     * @return actual_price - 实际需要支付的金额
     */
    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    /**
     * 设置实际需要支付的金额
     *
     * @param actualPrice 实际需要支付的金额
     */
    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    /**
     * @return integral
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * @param integral
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * @return integral_money
     */
    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }

    /**
     * @param integralMoney
     */
    public void setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
    }

    /**
     * 获取订单总价
     *
     * @return order_price - 订单总价
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * 设置订单总价
     *
     * @param orderPrice 订单总价
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取商品总价
     *
     * @return goods_price - 商品总价
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 设置商品总价
     *
     * @param goodsPrice 商品总价
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return confirm_time
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * @param confirmTime
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * @return pay_time
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取配送费用
     *
     * @return freight_price - 配送费用
     */
    public Integer getFreightPrice() {
        return freightPrice;
    }

    /**
     * 设置配送费用
     *
     * @param freightPrice 配送费用
     */
    public void setFreightPrice(Integer freightPrice) {
        this.freightPrice = freightPrice;
    }

    /**
     * 获取使用的优惠券id
     *
     * @return coupon_id - 使用的优惠券id
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * 设置使用的优惠券id
     *
     * @param couponId 使用的优惠券id
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return coupon_price
     */
    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    /**
     * @param couponPrice
     */
    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    /**
     * @return callback_status
     */
    public String getCallbackStatus() {
        return callbackStatus;
    }

    /**
     * @param callbackStatus
     */
    public void setCallbackStatus(String callbackStatus) {
        this.callbackStatus = callbackStatus;
    }
}