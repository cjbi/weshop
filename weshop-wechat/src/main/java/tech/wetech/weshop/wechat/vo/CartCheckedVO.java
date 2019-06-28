package tech.wetech.weshop.wechat.vo;

import javax.validation.constraints.NotNull;

public class CartCheckedVO {

    @NotNull
    private String productIds;

    @NotNull
    private Boolean checked;

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    public Boolean getChecked() {
        return checked;
    }

    public CartCheckedVO setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }
}
