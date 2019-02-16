package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.po.UserCoupon;

@FeignClient(value = "weshop-user", path = "userCoupon")
public interface UserCouponApi extends Api<UserCoupon> {
}
