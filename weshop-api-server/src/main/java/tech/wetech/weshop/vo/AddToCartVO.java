package tech.wetech.weshop.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddToCartVO {

    @NotNull
    private Integer goodsId;

    @NotNull
    private Integer productId;

    @NotNull
    @Min(1)
    private Integer number;

    public Integer getGoodsId() {
        return goodsId;
    }

    public AddToCartVO setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public AddToCartVO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public AddToCartVO setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
