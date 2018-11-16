package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.PageResult;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.domain.User;
import tech.wetech.weshop.query.UserPageQuery;
import tech.wetech.weshop.service.UserService;

import java.util.List;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public PageResult<List<User>> findUserPage(UserPageQuery userPageQuery) {
        List<User> users = userService.findUserPage(userPageQuery);
        int total = userService.countUser(userPageQuery);
        return PageResult.success(total, users);
    }

    @PostMapping("/create")
    public Result create() {
        return Result.success();
    }

    @PostMapping("/update")
    public Result update() {
        return Result.success();
    }

}
