package tech.wetech.weshop.domain;

import java.util.Date;
import javax.persistence.*;

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
     * @return coupon_id
     */
    public Byte getCouponId() {
        return couponId;
    }

    /**
     * @param couponId
     */
    public void setCouponId(Byte couponId) {
        this.couponId = couponId;
    }

    /**
     * @return coupon_number
     */
    public String getCouponNumber() {
        return couponNumber;
    }

    /**
     * @param couponNumber
     */
    public void setCouponNumber(String couponNumber) {
        this.couponNumber = couponNumber;
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
     * @return used_time
     */
    public Date getUsedTime() {
        return usedTime;
    }

    /**
     * @param usedTime
     */
    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    /**
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}