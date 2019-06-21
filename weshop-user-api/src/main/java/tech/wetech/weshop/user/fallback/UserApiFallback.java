package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;

@Component
public class UserApiFallback extends ApiFallback<User> implements UserApi {
}
