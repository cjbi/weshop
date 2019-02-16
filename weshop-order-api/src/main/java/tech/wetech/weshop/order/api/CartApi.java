package tech.wetech.weshop.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.order.dto.CartCheckoutDTO;
import tech.wetech.weshop.order.dto.CartParamDTO;
import tech.wetech.weshop.order.dto.CartResultDTO;
import tech.wetech.weshop.order.po.Cart;

@FeignClient(value = "weshop-order", path = "cart")
public interface CartApi extends Api<Cart> {

    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    CartResultDTO getCart();

    @PostMapping("/addGoodsToCart")
    void addGoodsToCart(@RequestBody CartParamDTO cartParamDTO);

    @PostMapping("/updateGoods")
    void updateGoods(@RequestBody CartParamDTO cartParamDTO);

    @RequestMapping(value = "/checkoutCart", method = RequestMethod.GET)
    CartCheckoutDTO checkoutCart(Integer addressId, Integer couponId);
}
