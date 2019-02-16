package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.po.User;

@FeignClient(value = "weshop-user", path = "user")
public interface UserApi extends Api<User> {
}
