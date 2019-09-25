package tech.wetech.weshop.wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.exception.WeshopException;
import tech.wetech.weshop.common.utils.JsonUtils;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.constants.WechatConstants;
import tech.wetech.weshop.wechat.utils.JwtHelper;

/**
 * @author cjbi
 */
@Api(tags = "开发人员测试接口，包括获取Token等，只在dev环境可见")
@RestController
@RequestMapping("/wechat/dev")
@Profile("dev")
public class WechatDevController {

  @Autowired
  private UserApi userApi;

  @PostMapping("{userId}/token")
  @ApiOperation("【慎用】根据id获取Token用于测试")
  public Result<String> getTokenByUserId(@PathVariable("userId") String userId) {
    User user = userApi.queryById(userId).getData();
    if (user == null) {
        throw new WeshopException(CommonResultStatus.RECORD_NOT_EXIST);
    }
    //生成token
    String token = JwtHelper.createJWT("wechat", JsonUtils.toJson(user), WechatConstants.JWT_TTL);
      return Result.success(token);
  }

}
