package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.wechat.dto.CartCheckoutDTO;
import tech.wetech.weshop.wechat.dto.CartParamDTO;
import tech.wetech.weshop.wechat.dto.CartResultDTO;
import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.service.IService;

public interface CartService extends IService<Cart> {

    CartResultDTO getCart();

    void addGoodsToCart(CartParamDTO cartParamDTO);

    void updateGoods(CartParamDTO cartParamDTO);

    CartCheckoutDTO checkoutCart(Integer addressId, Integer couponId);

}
