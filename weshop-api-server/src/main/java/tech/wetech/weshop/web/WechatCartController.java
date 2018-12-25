package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.service.CartService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CartVO;
import tech.wetech.weshop.vo.CartListVO;

import javax.validation.Valid;

@RestController
@RequestMapping("/wechat/cart")
public class WechatCartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public Result<CartListVO> queryList() {
        return Result.success(cartService.queryCartList());
    }

    @PostMapping
    public Result<CartListVO> addToCart(@RequestBody @Valid CartVO cartVO) {
        cartService.addToCart(cartVO);
        return Result.success(cartService.queryCartList());
    }

    @PostMapping("/{cartId}")
    public Result<CartListVO> updateCart(@RequestBody @Valid CartVO cartVO, @PathVariable Integer cartId) {
        cartVO.setId(cartId);
        cartService.updateCart(cartVO);
        return Result.success(cartService.queryCartList());
    }

}
