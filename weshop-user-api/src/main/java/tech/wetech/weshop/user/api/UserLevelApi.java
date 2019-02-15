package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.po.UserLevel;

@RequestMapping("/userLevel")
@FeignClient(value = "weshop-user-service")
public interface UserLevelApi extends Api<UserLevel> {
}
