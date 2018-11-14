package tech.wetech.weshop.modules.example.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.core.utils.BaseController;
import tech.wetech.weshop.core.utils.PageResult;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.modules.example.mapper.UserMapper;
import tech.wetech.weshop.modules.example.service.UserService;
import tech.wetech.weshop.modules.example.vo.UserCreateVO;
import tech.wetech.weshop.modules.example.vo.UserPageParamVO;
import tech.wetech.weshop.modules.example.vo.UserResultVO;
import tech.wetech.weshop.modules.example.vo.UserUpdateVO;

import javax.validation.Valid;
import java.util.List;

/**
 * @author cjbi
 */
@RestController
@Api(description = "用户接口")
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/users/{pageNum}/{pageSize}")
    @ApiOperation("测试分页查询用户")
    public List<UserResultVO> queryUserList(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return userService.findUserPage(new UserPageParamVO(pageSize, pageNum));
    }

    @GetMapping("/users")
    @ApiOperation("分页查询用户")
    public PageResult<List<UserResultVO>> findUserPage(@Valid UserPageParamVO userPageParamVO) {
        List<UserResultVO> list = userService.findUserPage(userPageParamVO);
        Integer total = userService.countUser(userPageParamVO);
        return PageResult.success(total, list);
    }

    @PostMapping("/user")
    @ApiOperation("创建用户")
    public Result<UserCreateVO> createUser(@Valid @RequestBody UserCreateVO userCreateVO) {
        userService.createUser(userCreateVO);
        return Result.success();
    }

    @PutMapping("/user")
    @ApiOperation("更新用户")
    public Result<UserUpdateVO> updateUser(@Valid @RequestBody UserUpdateVO userUpdateVO) {
        userService.updateUser(userUpdateVO);
        return Result.success();
    }

    @DeleteMapping("/user/{userId}")
    @ApiOperation("删除用户")
    public Result deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return Result.success();
    }


}
