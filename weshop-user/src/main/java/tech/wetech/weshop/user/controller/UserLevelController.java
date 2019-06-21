package tech.wetech.weshop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.user.api.UserLevelApi;
import tech.wetech.weshop.user.po.UserLevel;

@RestController
@RequestMapping("/userLevel")
public class UserLevelController extends BaseApi<UserLevel> implements UserLevelApi {
}
