package tech.wetech.weshop.order.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.enums.ResultCodeEnum;
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
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result addGoodsToCart(CartParamDTO cartParamDTO) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result updateGoods(CartParamDTO cartParamDTO) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<CartCheckoutDTO> checkoutCart(Integer addressId, Integer couponId) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }
}
