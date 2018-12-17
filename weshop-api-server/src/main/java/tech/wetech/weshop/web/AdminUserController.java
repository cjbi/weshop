package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.domain.User;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.domain.UserLevel;
import tech.wetech.weshop.enums.GenderEnum;
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
public class AdminUserController extends BaseController<User> {

    @Autowired
    private UserLevelService userLevelService;

    @Override
    public Result<PageInfoVO<User>> queryPageInfo(User entity, Integer pageNum, Integer pageSize) {
        Result<PageInfoVO<User>> result = super.queryPageInfo(entity, pageNum, pageSize);
        Map<String, Object> extra = new HashMap(16) {{
            put("userLevel", userLevelService.queryAll().stream().collect(Collectors.toMap(UserLevel::getId, UserLevel::getName)));
            put("gender", Arrays.stream(GenderEnum.values()).collect(Collectors.toMap(e -> e, GenderEnum::getName)));
        }};
        result.getData().setExtra(extra);
        return result;
    }

}
