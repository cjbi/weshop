package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.GenderEnum;
import tech.wetech.weshop.po.User;
import tech.wetech.weshop.po.UserLevel;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.UserLevelService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.base.BaseCrudController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController extends BaseCrudController<User> {

    @Autowired
    private UserLevelService userLevelService;

    @Override
    public Result<List<User>> queryList(User entity, PageQuery pageQuery) {
        return super.queryList(entity, pageQuery)
                .addExtra("userLevel", userLevelService.queryAll().stream().collect(Collectors.toMap(UserLevel::getId, UserLevel::getName)))
                .addExtra("gender", Arrays.stream(GenderEnum.values()).collect(Collectors.toMap(e -> e, GenderEnum::getName)));
    }

}
