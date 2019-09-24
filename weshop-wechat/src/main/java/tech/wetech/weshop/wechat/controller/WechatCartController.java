package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.wechat.service.WechatCartService;
import tech.wetech.weshop.wechat.vo.*;

@RestController
@RequestMapping("/wechat/cart")
public class WechatCartController extends BaseController {

    @Autowired
    private WechatCartService wechatCartService;

    @GetMapping("/index")
    public ResultWrapper<CartResultVO> getCart() {
        return ResultWrapper.success(wechatCartService.getCart());
    }

    @PostMapping("/add")
    public ResultWrapper<CartResultVO> addGoodsToCart(@RequestBody @Validated CartParamVO cartParamDTO) {
        wechatCartService.addGoodsToCart(cartParamDTO);
        return ResultWrapper.success(wechatCartService.getCart());
    }

    @PostMapping("/update")
    public ResultWrapper<CartResultVO> updateCartGoods(@RequestBody @Validated(CartParamVO.CartUpdateChecks.class) CartParamVO cartParamDTO) {
        wechatCartService.updateGoods(cartParamDTO);
        return ResultWrapper.success(wechatCartService.getCart());
    }

    @PostMapping("/delete")
    public ResultWrapper<CartResultVO> deleteCartGoods(@RequestBody @Validated CartGoodsDeleteVO cartGoodsDeleteVO) {
        wechatCartService.deleteCartGoods(cartGoodsDeleteVO);
        return ResultWrapper.success(wechatCartService.getCart());
    }

    @PostMapping("/checked")
    public ResultWrapper<CartResultVO> checkedCartGoods(@RequestBody @Validated CartCheckedVO cartCheckedVO) {
        wechatCartService.checkedCartGoods(cartCheckedVO);
        return ResultWrapper.success(wechatCartService.getCart());
    }

    @GetMapping("/goods-count")
    public ResultWrapper<Integer> goodsCount() {
        CartResultVO cart = wechatCartService.getCart();
        CartResultVO.CartTotalVO cartTotal = cart.getCartTotal();
        return ResultWrapper.success(cartTotal.getGoodsCount());
    }

    @GetMapping("/checkout")
    public ResultWrapper<CartCheckoutVO> checkoutCartGoods(Integer addressId, Integer couponId) {
        return ResultWrapper.success(wechatCartService.checkoutCart(addressId, couponId));
    }


}
