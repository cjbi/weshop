package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.user.api.UserCouponApi;
import tech.wetech.weshop.user.po.UserCoupon;

@Component
public class UserCouponApiFallback extends ApiFallback<UserCoupon> implements UserCouponApi {
}
