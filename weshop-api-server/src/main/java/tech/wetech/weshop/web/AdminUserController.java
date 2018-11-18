package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.domain.UserLevel;
import tech.wetech.weshop.enums.GenderEnum;
import tech.wetech.weshop.query.UserPageQuery;
import tech.wetech.weshop.service.UserLevelService;
import tech.wetech.weshop.service.UserService;
import tech.wetech.weshop.vo.CreateUserFormVO;
import tech.wetech.weshop.vo.Pagination;
import tech.wetech.weshop.vo.UpdateUserFormVO;
import tech.wetech.weshop.vo.UserPageVO;

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
    public Result<UserPageVO> findUserPageInfo(UserPageQuery userPageQuery) {
        PageInfo pageInfo = userService.findUserPageInfo(userPageQuery);
        Pagination pagination = new Pagination(pageInfo);
        UserPageVO userPageVO = new UserPageVO();
        Map<String, Object> extra = new HashMap<>(16);

        extra.put("userLevel", userLevelService.findAll().stream().collect(Collectors.toMap(UserLevel::getId, UserLevel::getName)));
        extra.put("gender", Arrays.stream(GenderEnum.values()).collect(Collectors.toMap(e -> e, GenderEnum::getName)));

        userPageVO.setPagination(pagination);
        userPageVO.setList(pageInfo.getList());
        userPageVO.setExtra(extra);
        return Result.success(userPageVO);
    }

    @PostMapping("/create")
    public Result createUser(@RequestBody CreateUserFormVO createUserFormVO) {
        userService.createUser(createUserFormVO);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateUser(UpdateUserFormVO updateUserFormVO) {
        userService.updateUser(updateUserFormVO);
        return Result.success();
    }

}
