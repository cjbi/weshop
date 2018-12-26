package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.service.CartService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CartCheckedVO;
import tech.wetech.weshop.vo.CartListVO;
import tech.wetech.weshop.vo.CartVO;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/cart")
@Validated
public class WechatCartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public Result<CartListVO> queryList() {
        return Result.success(cartService.queryCartList());
    }

    @PostMapping
    public Result<CartListVO> addToCart(@RequestBody @Validated CartVO cartVO) {
        cartService.addToCart(cartVO);
        return Result.success(cartService.queryCartList());
    }

    @PutMapping("/{cartId}")
    public Result<CartListVO> updateCart(@RequestBody @Validated(CartVO.CartUpdateChecks.class) CartVO cartVO, @PathVariable Integer cartId) {
        cartVO.setId(cartId);
        cartService.updateCart(cartVO);
        return Result.success(cartService.queryCartList());
    }

    @DeleteMapping
    public Result<CartListVO> deleteCart(@RequestBody @NotNull List<Integer> productIds) {
        cartService.deleteCart(productIds);
        return Result.success(cartService.queryCartList());
    }

    @PostMapping("/checked")
    public Result<CartListVO> checkedCart(@RequestBody @Validated CartCheckedVO cartCheckedVO) {
        return Result.success(cartService.queryCartList());
    }

}
