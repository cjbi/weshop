package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.vo.AddToCartVO;

public interface CartService extends IService<Cart> {

    void addToCart(AddToCartVO addToCartVO);
}
