package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.user.api.UserLevelApi;
import tech.wetech.weshop.user.po.UserLevel;

@Component
public class UserLevelApiFallback extends ApiFallback<UserLevel> implements UserLevelApi {
}
