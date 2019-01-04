package tech.wetech.weshop.vo;

import javax.validation.constraints.NotNull;

public class CartCheckedVO {

    @NotNull
    private Integer cartId;

    @NotNull
    private Boolean checked;

    public Integer getCartId() {
        return cartId;
    }

    public CartCheckedVO setCartId(Integer cartId) {
        this.cartId = cartId;
        return this;
    }

    public Boolean getChecked() {
        return checked;
    }

    public CartCheckedVO setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }
}
