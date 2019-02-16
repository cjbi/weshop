package tech.wetech.weshop.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserApi userApi;

    @GetMapping("/testUser")
    public Result<String> testUser(String name) {
        return userApi.sayHello(name);
    }

    @GetMapping("/queryUserList")
    public Result<List<User>> queryUserList(User user) {
        return userApi.queryList(user);
    }

    @PostMapping("/saveUser")
    public Result<String> saveUser(@RequestBody User user) {
        userApi.create(user);
        return Result.success("success");
    }

}
