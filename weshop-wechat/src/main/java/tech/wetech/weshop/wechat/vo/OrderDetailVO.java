package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.order.enums.OrderStatusEnum;
import tech.wetech.weshop.order.enums.PayStatusEnum;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.po.OrderExpress;
import tech.wetech.weshop.order.po.OrderGoods;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public class OrderDetailVO {

    private OrderInfoVO orderInfo;

    private List<OrderGoods> orderGoods;

    private HandleOptionVO handleOption;

    public OrderDetailVO() {
    }

    public OrderDetailVO(OrderInfoVO orderInfo, List<OrderGoods> orderGoods, HandleOptionVO handleOption) {
        this.orderInfo = orderInfo;
        this.orderGoods = orderGoods;
        this.handleOption = handleOption;
    }

    public static class OrderInfoVO {
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

        private OrderExpress orderExpress;

        private String provinceName;

        private String cityName;

        private String districtName;

        private String fullRegion;

        public OrderInfoVO() {
        }

        public OrderInfoVO(Order order) {
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
            this.orderExpress = null;
            this.provinceName = null;
            this.cityName = null;
            this.districtName = null;
            this.fullRegion = null;
        }

        public Integer getId() {
            return id;
        }

        public OrderInfoVO setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getOrderSN() {
            return orderSN;
        }

        public OrderInfoVO setOrderSN(String orderSN) {
            this.orderSN = orderSN;
            return this;
        }

        public Integer getUserId() {
            return userId;
        }

        public OrderInfoVO setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public OrderStatusEnum getOrderStatus() {
            return orderStatus;
        }

        public OrderInfoVO setOrderStatus(OrderStatusEnum orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Short getShippingStatus() {
            return shippingStatus;
        }

        public OrderInfoVO setShippingStatus(Short shippingStatus) {
            this.shippingStatus = shippingStatus;
            return this;
        }

        public PayStatusEnum getPayStatus() {
            return payStatus;
        }

        public OrderInfoVO setPayStatus(PayStatusEnum payStatus) {
            this.payStatus = payStatus;
            return this;
        }

        public String getConsignee() {
            return consignee;
        }

        public OrderInfoVO setConsignee(String consignee) {
            this.consignee = consignee;
            return this;
        }

        public Short getCountry() {
            return country;
        }

        public OrderInfoVO setCountry(Short country) {
            this.country = country;
            return this;
        }

        public Short getProvince() {
            return province;
        }

        public OrderInfoVO setProvince(Short province) {
            this.province = province;
            return this;
        }

        public Short getCity() {
            return city;
        }

        public OrderInfoVO setCity(Short city) {
            this.city = city;
            return this;
        }

        public Short getDistrict() {
            return district;
        }

        public OrderInfoVO setDistrict(Short district) {
            this.district = district;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public OrderInfoVO setAddress(String address) {
            this.address = address;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public OrderInfoVO setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getPostscript() {
            return postscript;
        }

        public OrderInfoVO setPostscript(String postscript) {
            this.postscript = postscript;
            return this;
        }

        public BigDecimal getShippingFee() {
            return shippingFee;
        }

        public OrderInfoVO setShippingFee(BigDecimal shippingFee) {
            this.shippingFee = shippingFee;
            return this;
        }

        public String getPayName() {
            return payName;
        }

        public OrderInfoVO setPayName(String payName) {
            this.payName = payName;
            return this;
        }

        public Byte getPayId() {
            return payId;
        }

        public OrderInfoVO setPayId(Byte payId) {
            this.payId = payId;
            return this;
        }

        public BigDecimal getActualPrice() {
            return actualPrice;
        }

        public OrderInfoVO setActualPrice(BigDecimal actualPrice) {
            this.actualPrice = actualPrice;
            return this;
        }

        public Integer getIntegral() {
            return integral;
        }

        public OrderInfoVO setIntegral(Integer integral) {
            this.integral = integral;
            return this;
        }

        public BigDecimal getIntegralMoney() {
            return integralMoney;
        }

        public OrderInfoVO setIntegralMoney(BigDecimal integralMoney) {
            this.integralMoney = integralMoney;
            return this;
        }

        public BigDecimal getOrderPrice() {
            return orderPrice;
        }

        public OrderInfoVO setOrderPrice(BigDecimal orderPrice) {
            this.orderPrice = orderPrice;
            return this;
        }

        public BigDecimal getGoodsPrice() {
            return goodsPrice;
        }

        public OrderInfoVO setGoodsPrice(BigDecimal goodsPrice) {
            this.goodsPrice = goodsPrice;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public OrderInfoVO setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getConfirmTime() {
            return confirmTime;
        }

        public OrderInfoVO setConfirmTime(Date confirmTime) {
            this.confirmTime = confirmTime;
            return this;
        }

        public Date getPayTime() {
            return payTime;
        }

        public OrderInfoVO setPayTime(Date payTime) {
            this.payTime = payTime;
            return this;
        }

        public BigDecimal getFreightPrice() {
            return freightPrice;
        }

        public OrderInfoVO setFreightPrice(BigDecimal freightPrice) {
            this.freightPrice = freightPrice;
            return this;
        }

        public Integer getCouponId() {
            return couponId;
        }

        public OrderInfoVO setCouponId(Integer couponId) {
            this.couponId = couponId;
            return this;
        }

        public Integer getParentId() {
            return parentId;
        }

        public OrderInfoVO setParentId(Integer parentId) {
            this.parentId = parentId;
            return this;
        }

        public BigDecimal getCouponPrice() {
            return couponPrice;
        }

        public OrderInfoVO setCouponPrice(BigDecimal couponPrice) {
            this.couponPrice = couponPrice;
            return this;
        }

        public String getCallbackStatus() {
            return callbackStatus;
        }

        public OrderInfoVO setCallbackStatus(String callbackStatus) {
            this.callbackStatus = callbackStatus;
            return this;
        }

        public OrderExpress getOrderExpress() {
            return orderExpress;
        }

        public OrderInfoVO setOrderExpress(OrderExpress orderExpress) {
            this.orderExpress = orderExpress;
            return this;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public OrderInfoVO setProvinceName(String provinceName) {
            this.provinceName = provinceName;
            return this;
        }

        public String getCityName() {
            return cityName;
        }

        public OrderInfoVO setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public String getDistrictName() {
            return districtName;
        }

        public OrderInfoVO setDistrictName(String districtName) {
            this.districtName = districtName;
            return this;
        }

        public String getFullRegion() {
            return fullRegion;
        }

        public OrderInfoVO setFullRegion(String fullRegion) {
            this.fullRegion = fullRegion;
            return this;
        }
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public OrderInfoVO getOrderInfo() {
        return orderInfo;
    }

    public OrderDetailVO setOrderInfo(OrderInfoVO orderInfo) {
        this.orderInfo = orderInfo;
        return this;
    }

    public HandleOptionVO getHandleOption() {
        return handleOption;
    }

    public OrderDetailVO setHandleOption(HandleOptionVO handleOption) {
        this.handleOption = handleOption;
        return this;
    }
}
