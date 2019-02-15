package tech.wetech.weshop.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.order.dto.CartCheckoutDTO;
import tech.wetech.weshop.order.dto.CartParamDTO;
import tech.wetech.weshop.order.dto.CartResultDTO;
import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.service.IService;

@RequestMapping("/cart")
@FeignClient(value = "weshop-order-service")
public interface CartService extends IService<Cart> {

    @GetMapping("/getCart")
    CartResultDTO getCart();

    @PostMapping("/addGoodsToCart")
    void addGoodsToCart(@RequestBody CartParamDTO cartParamDTO);

    @PostMapping("/updateGoods")
    void updateGoods(@RequestBody CartParamDTO cartParamDTO);

    @GetMapping("/checkoutCart")
    CartCheckoutDTO checkoutCart(Integer addressId, Integer couponId);

}
