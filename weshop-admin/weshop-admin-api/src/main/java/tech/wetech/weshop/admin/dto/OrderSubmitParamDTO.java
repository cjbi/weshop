package tech.wetech.weshop.admin.dto;

import javax.validation.constraints.NotNull;

public class OrderSubmitParamDTO {

    @NotNull
    private Integer addressId;

    private Integer couponId;

    private String postscript;

    public Integer getAddressId() {
        return addressId;
    }

    public OrderSubmitParamDTO setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public OrderSubmitParamDTO setCouponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    public String getPostscript() {
        return postscript;
    }

    public OrderSubmitParamDTO setPostscript(String postscript) {
        this.postscript = postscript;
        return this;
    }
}
