package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.po.UserCoupon;

@RequestMapping("/userCoupon")
@FeignClient(value = "weshop-user")
public interface UserCouponApi extends Api<UserCoupon> {
}
