package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.order.api.CartApi;
import tech.wetech.weshop.order.dto.CartCheckoutDTO;
import tech.wetech.weshop.order.dto.CartParamDTO;
import tech.wetech.weshop.order.dto.CartResultDTO;
import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.utils.Result;

@Component
public class CartApiFallback extends ApiFallback<Cart> implements CartApi {
    @Override
    public Result<CartResultDTO> getCart() {
        return null;
    }

    @Override
    public Result addGoodsToCart(CartParamDTO cartParamDTO) {
        return null;
    }

    @Override
    public Result updateGoods(CartParamDTO cartParamDTO) {
        return null;
    }

    @Override
    public Result<CartCheckoutDTO> checkoutCart(Integer addressId, Integer couponId) {
        return null;
    }
}
