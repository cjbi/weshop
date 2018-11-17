package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.query.UserPageQuery;
import tech.wetech.weshop.service.UserService;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result<PageInfo> findUserPageInfo(UserPageQuery userPageQuery) {
        return Result.success(userService.findUserPageInfo(userPageQuery));
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
