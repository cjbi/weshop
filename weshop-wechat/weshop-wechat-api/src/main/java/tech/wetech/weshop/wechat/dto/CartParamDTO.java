package tech.wetech.weshop.wechat.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartParamDTO {

    @NotNull(groups = CartUpdateChecks.class)
    private Integer id;

    @NotNull
    private Integer goodsId;

    @NotNull
    private Integer productId;

    @NotNull
    @Min(1)
    private Integer number;

    public interface CartUpdateChecks {
        //更新购物车的分组
    }

    public Integer getId() {
        return id;
    }

    public CartParamDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public CartParamDTO setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public CartParamDTO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public CartParamDTO setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
