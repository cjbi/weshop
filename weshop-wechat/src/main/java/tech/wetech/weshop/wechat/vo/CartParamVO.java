package tech.wetech.weshop.wechat.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartParamVO {

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

    public CartParamVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public CartParamVO setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public CartParamVO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public CartParamVO setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
