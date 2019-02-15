package tech.wetech.weshop.user.web;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;

@RestController
public class UserController extends BaseApi<User> implements UserApi {
}
