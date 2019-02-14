package tech.wetech.weshop.user.service;

import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.po.User;

@RequestMapping("/user")
public interface UserService extends IService<User> {
}
