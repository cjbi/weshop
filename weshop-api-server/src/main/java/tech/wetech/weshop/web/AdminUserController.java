package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.po.UserLevel;
import tech.wetech.weshop.enums.GenderEnum;
import tech.wetech.weshop.query.UserPageQuery;
import tech.wetech.weshop.service.UserLevelService;
import tech.wetech.weshop.service.UserService;
import tech.wetech.weshop.vo.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserLevelService userLevelService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryUserPageInfo(UserPageQuery userPageQuery) {
        PageInfo pageInfo = userService.queryUserPageInfo(userPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO.Builder(pageInfo)
                .addExtra("userLevel",userLevelService.queryAll().stream().collect(Collectors.toMap(UserLevel::getId, UserLevel::getName)))
                .addExtra("gender",Arrays.stream(GenderEnum.values()).collect(Collectors.toMap(e -> e, GenderEnum::getName)))
                .build();
        return Result.success(pageInfoVO);
    }

    @PostMapping("/create")
    public Result createUser(@RequestBody CreateUserFormVO createUserFormVO) {
        userService.createUser(createUserFormVO);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateUser(@RequestBody UpdateUserFormVO updateUserFormVO) {
        userService.updateUser(updateUserFormVO);
        return Result.success();
    }


    @PostMapping("/delete")
    public Result deleteUser(@RequestBody Integer[] userIds) {
        userService.deleteUser(userIds);
        return Result.success(userIds);
    }

}
