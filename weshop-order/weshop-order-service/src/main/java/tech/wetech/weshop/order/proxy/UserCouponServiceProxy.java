package tech.wetech.weshop.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.user.service.UserCouponService;

@FeignClient(value = "weshop-user-service")
public interface UserCouponServiceProxy extends UserCouponService {

}
