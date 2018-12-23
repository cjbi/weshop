package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.service.CartService;
import tech.wetech.weshop.vo.CartListVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/wechat/cart")
public class WechatCartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public CartListVO queryList() {
        Integer loginUserId = 1;
        String sessionId = "1";
        List<Cart> cartList = cartService.queryList(new Cart() {{
            setUserId(loginUserId);
            setSessionId(sessionId);
        }});
        CartListVO.CartTotalVO cartTotalVO = new CartListVO.CartTotalVO();
        Stream<Cart> stream = cartList.stream();
        cartTotalVO.setGoodsCount(
                cartList.size()
        );
        // 使用reduce聚合函数,实现累加器
        cartTotalVO.setGoodsAmount(
                stream.map(Cart::getRetailPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
        );
        cartTotalVO.setCheckedGoodsCount(
                stream.filter(Cart::getChecked).mapToInt(c -> 1).sum()
        );
        cartTotalVO.setCheckedGoodsAmount(
                stream.filter(Cart::getChecked).map(Cart::getRetailPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
        );
        return new CartListVO(cartList, cartTotalVO);
    }

}
