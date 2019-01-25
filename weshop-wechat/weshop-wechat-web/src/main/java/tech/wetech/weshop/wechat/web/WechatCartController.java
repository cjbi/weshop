package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.wechat.service.CartService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.wechat.dto.CartCheckedDTO;
import tech.wetech.weshop.wechat.dto.CartCheckoutDTO;
import tech.wetech.weshop.wechat.dto.CartParamDTO;
import tech.wetech.weshop.wechat.dto.CartResultDTO;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/cart")
@Validated
public class WechatCartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/index")
    public Result<CartResultDTO> getCart() {
        return Result.success(cartService.getCart());
    }

    @PostMapping("/add-to-cart")
    public Result<CartResultDTO> addGoodsToCart(@RequestBody @Validated CartParamDTO cartParamDTO) {
        cartService.addGoodsToCart(cartParamDTO);
        return Result.success(cartService.getCart());
    }

    @PostMapping("/update-goods")
    public Result<CartResultDTO> updateCartGoods(@RequestBody @Validated(CartParamDTO.CartUpdateChecks.class) CartParamDTO cartParamDTO) {
        cartService.updateGoods(cartParamDTO);
        return Result.success(cartService.getCart());
    }

    @PostMapping("/delete")
    public Result<CartResultDTO> deleteCartGoods(@NotNull Integer cartId) {
        cartService.deleteById(cartId);
        return Result.success(cartService.getCart());
    }

    @PostMapping("/checked")
    public Result<CartResultDTO> checkedCartGoods(@RequestBody @Validated CartCheckedDTO cartCheckedDTO) {
        cartService.updateNotNull(new Cart()
                .setId(cartCheckedDTO.getCartId())
                .setChecked(cartCheckedDTO.getChecked()));
        return Result.success(cartService.getCart());
    }

    @GetMapping("/goods-count")
    public Result<Integer> goodsCount() {
        int count = cartService.count(new Cart()
                .setUserId(Constants.CURRENT_USER_ID)
                .setSessionId(Constants.SESSION_ID));
        return Result.success(count);
    }

    @GetMapping("/checkout")
    public Result<CartCheckoutDTO> checkoutCartGoods(Integer addressId, Integer couponId) {
        return Result.success(cartService.checkoutCart(addressId, couponId));
    }


}
