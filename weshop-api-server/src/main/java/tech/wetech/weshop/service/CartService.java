package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.vo.CartVO;
import tech.wetech.weshop.vo.CartListVO;

import java.util.List;

public interface CartService extends IService<Cart> {

    CartListVO queryCartList();

    void addToCart(CartVO cartVO);

    void updateCart(CartVO cartVO);

    void deleteCart(List<Integer> productIds);

}
