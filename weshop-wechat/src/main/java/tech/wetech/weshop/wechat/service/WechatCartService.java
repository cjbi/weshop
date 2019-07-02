package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.wechat.vo.*;

public interface WechatCartService {

    CartResultVO getCart();

    void deleteCartGoods(CartGoodsDeleteVO deleteVO);

    void checkedCartGoods(CartCheckedVO cartCheckedVO);

    void addGoodsToCart(CartParamVO cartParamDTO);

    void updateGoods(CartParamVO cartParamDTO);

    CartCheckoutVO checkoutCart(Integer addressId, Integer couponId);

}
