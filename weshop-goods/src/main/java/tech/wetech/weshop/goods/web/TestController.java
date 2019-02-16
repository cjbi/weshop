package tech.wetech.weshop.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.user.api.UserApi;

@RestController
public class TestController {

    @Autowired
    private UserApi userApi;

    @GetMapping("/testUser")
    public String testUser(String name) {
        return userApi.sayHello(name);
    }

}
