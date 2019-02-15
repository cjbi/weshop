package tech.wetech.weshop.user.web;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.UserLevelApi;
import tech.wetech.weshop.user.po.UserLevel;

@RestController
public class UserLevelController extends BaseApi<UserLevel> implements UserLevelApi {
}
