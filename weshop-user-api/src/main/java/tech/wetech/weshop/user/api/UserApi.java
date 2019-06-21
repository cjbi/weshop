package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.fallback.UserApiFallback;
import tech.wetech.weshop.user.po.User;

@FeignClient(value = "weshop-user", path = "user", fallback = UserApiFallback.class)
public interface UserApi extends Api<User> {
}
