package tech.wetech.weshop.admin.dto;

import tech.wetech.weshop.po.Cart;

import java.math.BigDecimal;
import java.util.List;

public class CartResultDTO {

    private List<Cart> cartList;

    private CartTotalVO cartTotal;

    public CartResultDTO(List<Cart> cartList, CartTotalVO cartTotal) {
        this.cartList = cartList;
        this.cartTotal = cartTotal;
    }

    public static class CartTotalVO {

        private Integer goodsCount;

        private BigDecimal goodsAmount;

        private Integer checkedGoodsCount;

        private BigDecimal checkedGoodsAmount;

        public Integer getGoodsCount() {
            return goodsCount;
        }

        public CartTotalVO setGoodsCount(Integer goodsCount) {
            this.goodsCount = goodsCount;
            return this;
        }

        public BigDecimal getGoodsAmount() {
            return goodsAmount;
        }

        public CartTotalVO setGoodsAmount(BigDecimal goodsAmount) {
            this.goodsAmount = goodsAmount;
            return this;
        }

        public Integer getCheckedGoodsCount() {
            return checkedGoodsCount;
        }

        public CartTotalVO setCheckedGoodsCount(Integer checkedGoodsCount) {
            this.checkedGoodsCount = checkedGoodsCount;
            return this;
        }

        public BigDecimal getCheckedGoodsAmount() {
            return checkedGoodsAmount;
        }

        public CartTotalVO setCheckedGoodsAmount(BigDecimal checkedGoodsAmount) {
            this.checkedGoodsAmount = checkedGoodsAmount;
            return this;
        }
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public CartResultDTO setCartList(List<Cart> cartList) {
        this.cartList = cartList;
        return this;
    }

    public CartTotalVO getCartTotal() {
        return cartTotal;
    }

    public CartResultDTO setCartTotal(CartTotalVO cartTotal) {
        this.cartTotal = cartTotal;
        return this;
    }
}
