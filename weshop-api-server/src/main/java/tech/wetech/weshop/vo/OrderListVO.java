package tech.wetech.weshop.vo;

import tech.wetech.weshop.enums.OrderStatusEnum;
import tech.wetech.weshop.enums.PayStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

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
    private Integer freightPrice;

    /**
     * 使用的优惠券id
     */
    private Integer couponId;

    private Integer parentId;

    private BigDecimal couponPrice;

    private String callbackStatus;

}
