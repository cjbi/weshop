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
import tech.wetech.weshop.vo.PageInfoVO;

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
    public Result<PageInfoVO<User>> queryPageInfo(User entity, PageQuery pageQuery) {
        Result<PageInfoVO<User>> result = super.queryPageInfo(entity, pageQuery);
        Map<String, Object> extra = new HashMap(16) {{
            put("userLevel", userLevelService.queryAll().stream().collect(Collectors.toMap(UserLevel::getId, UserLevel::getName)));
            put("gender", Arrays.stream(GenderEnum.values()).collect(Collectors.toMap(e -> e, GenderEnum::getName)));
        }};
        result.getData().setExtra(extra);
        return result;
    }

}
