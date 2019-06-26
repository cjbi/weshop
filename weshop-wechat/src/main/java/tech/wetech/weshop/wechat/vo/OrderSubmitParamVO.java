package tech.wetech.weshop.wechat.vo;

import javax.validation.constraints.NotNull;

public class OrderSubmitParamVO {

    @NotNull
    private Integer addressId;

    private Integer couponId;

    private String postscript;

    public Integer getAddressId() {
        return addressId;
    }

    public OrderSubmitParamVO setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public OrderSubmitParamVO setCouponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    public String getPostscript() {
        return postscript;
    }

    public OrderSubmitParamVO setPostscript(String postscript) {
        this.postscript = postscript;
        return this;
    }
}
