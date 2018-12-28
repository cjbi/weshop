package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.vo.CartCheckoutVO;
import tech.wetech.weshop.vo.CartGoodsListVO;
import tech.wetech.weshop.vo.CartVO;

public interface CartService extends IService<Cart> {

    CartGoodsListVO queryList();

    void addToCart(CartVO cartVO);

    void updateCart(CartVO cartVO);

    CartCheckoutVO checkoutCart(Integer addressId, Integer couponId);

}
