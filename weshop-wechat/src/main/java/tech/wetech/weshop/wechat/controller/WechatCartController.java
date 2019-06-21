package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.controller.BaseController;
import tech.wetech.weshop.order.api.CartApi;
import tech.wetech.weshop.order.dto.CartCheckoutDTO;
import tech.wetech.weshop.order.dto.CartParamDTO;
import tech.wetech.weshop.order.dto.CartResultDTO;
import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.wechat.vo.CartCheckedVO;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/cart")
@Validated
public class WechatCartController extends BaseController {

    @Autowired
    private CartApi cartApi;

    @GetMapping("/index")
    public Result<CartResultDTO> getCart() {
        return cartApi.getCart();
    }

    @PostMapping("/add-to-cart")
    public Result<CartResultDTO> addGoodsToCart(@RequestBody @Validated CartParamDTO cartParamDTO) {
        cartApi.addGoodsToCart(cartParamDTO);
        return cartApi.getCart();
    }

    @PostMapping("/update-goods")
    public Result<CartResultDTO> updateCartGoods(@RequestBody @Validated(CartParamDTO.CartUpdateChecks.class) CartParamDTO cartParamDTO) {
        cartApi.updateGoods(cartParamDTO);
        return cartApi.getCart();
    }

    @PostMapping("/delete")
    public Result<CartResultDTO> deleteCartGoods(@NotNull Integer cartId) {
        cartApi.deleteById(cartId);
        return cartApi.getCart();
    }

    @PostMapping("/checked")
    public Result<CartResultDTO> checkedCartGoods(@RequestBody @Validated CartCheckedVO cartCheckedVO) {
        cartApi.updateNotNull(new Cart()
                .setId(cartCheckedVO.getCartId())
                .setChecked(cartCheckedVO.getChecked()));
        return cartApi.getCart();
    }

    @GetMapping("/goods-count")
    public Result<Integer> goodsCount() {
        Integer count = cartApi.count(new Cart()
                .setUserId(Constants.CURRENT_USER_ID)
                .setSessionId(Constants.SESSION_ID)).getData();
        return Result.success(count);
    }

    @GetMapping("/checkout")
    public Result<CartCheckoutDTO> checkoutCartGoods(Integer addressId, Integer couponId) {
        return cartApi.checkoutCart(addressId, couponId);
    }


}
