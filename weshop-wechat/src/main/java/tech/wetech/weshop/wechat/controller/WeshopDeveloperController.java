package tech.wetech.weshop.wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.exception.BizException;
import tech.wetech.weshop.common.utils.JsonUtils;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.constants.WechatConstants;
import tech.wetech.weshop.wechat.utils.JwtHelper;

@Api(tags = "开发人员测试接口，包括获取Token等，只在dev环境可见")
@RestController
@RequestMapping("/wechat/dev")
@ConditionalOnProperty(name = "spring.cloud.config.profile", havingValue = "dev")
public class WeshopDeveloperController {

    @Autowired
    private UserApi userApi;

    @PostMapping("{userId}/token")
    @ApiOperation("【慎用】根据id获取Token用于测试")
    public Result<String> getTokenByUserId(@PathVariable("userId") String userId) {
        User user = userApi.queryById(userId).getData();
        if (user == null) {
            throw new BizException(ResultStatus.RECORD_NOT_EXIST);
        }
        //生成token
        String token = JwtHelper.createJWT("wechat", JsonUtils.toJson(user), WechatConstants.JWT_TTL);
        return Result.success(token);
    }

}
