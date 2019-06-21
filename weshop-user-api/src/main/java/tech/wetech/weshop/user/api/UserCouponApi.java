package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.fallback.UserCouponApiFallback;
import tech.wetech.weshop.user.po.UserCoupon;

@FeignClient(value = "weshop-user", path = "userCoupon", fallback = UserCouponApiFallback.class)
public interface UserCouponApi extends Api<UserCoupon> {
}
