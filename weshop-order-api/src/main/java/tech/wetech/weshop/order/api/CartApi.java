package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.order.dto.CartCheckoutDTO;
import tech.wetech.weshop.order.dto.CartParamDTO;
import tech.wetech.weshop.order.dto.CartResultDTO;
import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.utils.Result;

@FeignClient(value = "weshop-order", path = "cart")
public interface CartApi extends Api<Cart> {

    @GetMapping("/getCart")
    Result<CartResultDTO> getCart();

    @PostMapping("/addGoodsToCart")
    Result addGoodsToCart(@RequestBody CartParamDTO cartParamDTO);

    @PostMapping("/updateGoods")
    Result updateGoods(@RequestBody CartParamDTO cartParamDTO);

    @GetMapping("/checkoutCart")
    Result<CartCheckoutDTO> checkoutCart(Integer addressId, Integer couponId);
}
