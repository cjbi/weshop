package tech.wetech.weshop.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.po.UserLevel;

@RequestMapping("/userLevel")
public interface UserLevelService extends IService<UserLevel> {
}
