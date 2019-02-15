package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.util.Date;

@Table(name = "weshop_user_coupon")
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coupon_id")
    private Byte couponId;

    @Column(name = "coupon_number")
    private String couponNumber;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "used_time")
    private Date usedTime;

    @Column(name = "order_id")
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public UserCoupon setId(Integer id) {
        this.id = id;
        return this;
    }

    public Byte getCouponId() {
        return couponId;
    }

    public UserCoupon setCouponId(Byte couponId) {
        this.couponId = couponId;
        return this;
    }

    public String getCouponNumber() {
        return couponNumber;
    }

    public UserCoupon setCouponNumber(String couponNumber) {
        this.couponNumber = couponNumber;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserCoupon setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public UserCoupon setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public UserCoupon setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }
}