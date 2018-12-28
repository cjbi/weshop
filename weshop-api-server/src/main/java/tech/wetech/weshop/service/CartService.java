package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.vo.CartCheckoutVO;
import tech.wetech.weshop.vo.CartResultVO;
import tech.wetech.weshop.vo.CartParamVO;

public interface CartService extends IService<Cart> {

    CartResultVO getCart();

    void addGoodsToCart(CartParamVO cartParamVO);

    void updateGoods(CartParamVO cartParamVO);

    CartCheckoutVO checkoutCart(Integer addressId, Integer couponId);

}
