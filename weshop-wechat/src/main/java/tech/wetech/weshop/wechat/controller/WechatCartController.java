package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.wechat.service.WechatCartService;
import tech.wetech.weshop.wechat.vo.*;

@RestController
@RequestMapping("/wechat/cart")
public class WechatCartController extends BaseController {

    @Autowired
    private WechatCartService wechatCartService;

    @GetMapping("/index")
    public Result<CartResultVO> getCart() {
        return Result.success(wechatCartService.getCart());
    }

    @PostMapping("/add")
    public Result<CartResultVO> addGoodsToCart(@RequestBody @Validated CartParamVO cartParamDTO) {
        wechatCartService.addGoodsToCart(cartParamDTO);
        return Result.success(wechatCartService.getCart());
    }

    @PostMapping("/update")
    public Result<CartResultVO> updateCartGoods(@RequestBody @Validated(CartParamVO.CartUpdateChecks.class) CartParamVO cartParamDTO) {
        wechatCartService.updateGoods(cartParamDTO);
        return Result.success(wechatCartService.getCart());
    }

    @PostMapping("/delete")
    public Result<CartResultVO> deleteCartGoods(@RequestBody @Validated CartGoodsDeleteVO cartGoodsDeleteVO) {
        wechatCartService.deleteCartGoods(cartGoodsDeleteVO);
        return Result.success(wechatCartService.getCart());
    }

    @PostMapping("/checked")
    public Result<CartResultVO> checkedCartGoods(@RequestBody @Validated CartCheckedVO cartCheckedVO) {
        wechatCartService.checkedCartGoods(cartCheckedVO);
        return Result.success(wechatCartService.getCart());
    }

    @GetMapping("/goods-count")
    public Result<Integer> goodsCount() {
        CartResultVO cart = wechatCartService.getCart();
        CartResultVO.CartTotalVO cartTotal = cart.getCartTotal();
        return Result.success(cartTotal.getGoodsCount());
    }

    @GetMapping("/checkout")
    public Result<CartCheckoutVO> checkoutCartGoods(Integer addressId, Integer couponId) {
        return Result.success(wechatCartService.checkoutCart(addressId, couponId));
    }


}
