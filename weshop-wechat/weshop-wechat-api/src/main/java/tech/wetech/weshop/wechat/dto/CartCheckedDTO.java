package tech.wetech.weshop.wechat.dto;

import javax.validation.constraints.NotNull;

public class CartCheckedDTO {

    @NotNull
    private Integer cartId;

    @NotNull
    private Boolean checked;

    public Integer getCartId() {
        return cartId;
    }

    public CartCheckedDTO setCartId(Integer cartId) {
        this.cartId = cartId;
        return this;
    }

    public Boolean getChecked() {
        return checked;
    }

    public CartCheckedDTO setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }
}
