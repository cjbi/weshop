package tech.wetech.weshop.vo;

import javax.validation.constraints.NotNull;

public class OrderSubmitVO {

    @NotNull
    private Integer addressId;

    private Integer couponId;

    private String postscript;

    public Integer getAddressId() {
        return addressId;
    }

    public OrderSubmitVO setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public OrderSubmitVO setCouponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    public String getPostscript() {
        return postscript;
    }

    public OrderSubmitVO setPostscript(String postscript) {
        this.postscript = postscript;
        return this;
    }
}
