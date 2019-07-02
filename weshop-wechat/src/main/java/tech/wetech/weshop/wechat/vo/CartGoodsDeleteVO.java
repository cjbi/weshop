package tech.wetech.weshop.wechat.vo;

import javax.validation.constraints.NotBlank;

public class CartGoodsDeleteVO {

    @NotBlank
    private String productIds;

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }
}
