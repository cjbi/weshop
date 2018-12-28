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

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
