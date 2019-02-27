package tech.wetech.weshop.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.query.PageQueryWrapper;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.api.UserLevelApi;
import tech.wetech.weshop.user.enums.GenderEnum;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.user.po.UserLevel;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController {

    @Autowired
    private UserApi userApi;

    @Autowired
    private UserLevelApi userLevelApi;

    @GetMapping("/list")
    public Result<List<User>> queryList(User entity, PageQuery pageQuery) {
        return userApi.queryPageList(new PageQueryWrapper<>(pageQuery, entity))
                .addExtra("userLevel", userLevelApi.queryAll().getData().stream().collect(Collectors.toMap(UserLevel::getId, UserLevel::getName)))
                .addExtra("gender", Arrays.stream(GenderEnum.values()).collect(Collectors.toMap(e -> e, GenderEnum::getName)));
    }

}
