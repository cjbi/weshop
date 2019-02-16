package tech.wetech.weshop.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.order.api.CartApi;
import tech.wetech.weshop.order.dto.CartCheckoutDTO;
import tech.wetech.weshop.order.dto.CartParamDTO;
import tech.wetech.weshop.order.dto.CartResultDTO;
import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.order.service.CartService;

@RequestMapping("/cart")
@RestController
public class CartController extends BaseApi<Cart> implements CartApi {

    @Autowired
    private CartService cartService;

    @Override
    public CartResultDTO getCart() {
        return cartService.getCart();
    }

    @Override
    public void addGoodsToCart(CartParamDTO cartParamDTO) {
        cartService.addGoodsToCart(cartParamDTO);
    }

    @Override
    public void updateGoods(CartParamDTO cartParamDTO) {
        cartService.updateGoods(cartParamDTO);
    }

    @Override
    public CartCheckoutDTO checkoutCart(Integer addressId, Integer couponId) {
        return cartService.checkoutCart(addressId, couponId);
    }
}
