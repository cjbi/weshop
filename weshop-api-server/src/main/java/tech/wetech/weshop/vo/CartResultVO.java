package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Cart;

import java.math.BigDecimal;
import java.util.List;

public class CartResultVO {

    private List<Cart> cartList;

    private CartTotalVO cartTotal;

    public CartResultVO(List<Cart> cartList, CartTotalVO cartTotal) {
        this.cartList = cartList;
        this.cartTotal = cartTotal;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public CartTotalVO getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotalVO cartTotal) {
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

        public void setGoodsCount(Integer goodsCount) {
            this.goodsCount = goodsCount;
        }

        public BigDecimal getGoodsAmount() {
            return goodsAmount;
        }

        public void setGoodsAmount(BigDecimal goodsAmount) {
            this.goodsAmount = goodsAmount;
        }

        public Integer getCheckedGoodsCount() {
            return checkedGoodsCount;
        }

        public void setCheckedGoodsCount(Integer checkedGoodsCount) {
            this.checkedGoodsCount = checkedGoodsCount;
        }

        public BigDecimal getCheckedGoodsAmount() {
            return checkedGoodsAmount;
        }

        public void setCheckedGoodsAmount(BigDecimal checkedGoodsAmount) {
            this.checkedGoodsAmount = checkedGoodsAmount;
        }
    }
}
