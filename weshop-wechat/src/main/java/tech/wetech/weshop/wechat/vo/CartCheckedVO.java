package tech.wetech.weshop.wechat.vo;

public class CartCheckedVO {

    private Integer cartId;

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
