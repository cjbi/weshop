package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.fallback.UserLevelApiFallback;
import tech.wetech.weshop.user.po.UserLevel;

@FeignClient(value = "weshop-user", path = "userLevel", fallback = UserLevelApiFallback.class)
public interface UserLevelApi extends Api<UserLevel> {
}
