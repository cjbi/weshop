package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.po.UserLevel;

@FeignClient(value = "weshop-user", path = "userLevel")
public interface UserLevelApi extends Api<UserLevel> {
}
