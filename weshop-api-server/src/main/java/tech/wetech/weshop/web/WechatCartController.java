package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.service.CartService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CartCheckedVO;
import tech.wetech.weshop.vo.CartCheckoutVO;
import tech.wetech.weshop.vo.CartGoodsListVO;
import tech.wetech.weshop.vo.CartVO;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/cart")
@Validated
public class WechatCartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public Result<CartGoodsListVO> queryList() {
        return Result.success(cartService.queryList());
    }

    @PostMapping
    public Result<CartGoodsListVO> addGoodsToCart(@RequestBody @Validated CartVO cartVO) {
        cartService.addToCart(cartVO);
        return Result.success(cartService.queryList());
    }

    @PutMapping
    public Result<CartGoodsListVO> updateCartGoods(@RequestBody @Validated(CartVO.CartUpdateChecks.class) CartVO cartVO) {
        cartService.updateCart(cartVO);
        return Result.success(cartService.queryList());
    }

    @DeleteMapping("/{cartId}")
    public Result<CartGoodsListVO> deleteCartGoods(@PathVariable Integer cartId) {
        cartService.deleteById(cartId);
        return Result.success(cartService.queryList());
    }

    @PostMapping("/checked")
    public Result<CartGoodsListVO> checkedCartGoods(@RequestBody @Validated CartCheckedVO cartCheckedVO) {
        cartService.updateNotNull(new Cart() {{
            setId(cartCheckedVO.getCartId());
            setChecked(cartCheckedVO.getChecked());
        }});
        return Result.success(cartService.queryList());
    }

    @GetMapping("/checkout")
    public Result<CartCheckoutVO> checkoutCartGood(@NotNull Integer addressId, Integer couponId) {

        return Result.success();
    }


}
