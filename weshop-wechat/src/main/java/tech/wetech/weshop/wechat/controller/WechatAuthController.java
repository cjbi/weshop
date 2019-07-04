package tech.wetech.weshop.wechat.controller;

import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.JsonUtils;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.constants.WechatConstants;
import tech.wetech.weshop.wechat.service.WechatAuthService;
import tech.wetech.weshop.wechat.utils.JwtHelper;
import tech.wetech.weshop.wechat.vo.LoginAuthParamVO;
import tech.wetech.weshop.wechat.vo.LoginAuthResultVO;

@RestController
@RequestMapping("/wechat/auth")
public class WechatAuthController extends BaseController {

    @Autowired
    private WechatAuthService wechatAuthService;

    @Autowired
    private UserApi userApi;


    @PostMapping("/loginByWeixin")
    public Result<LoginAuthResultVO> loginByWeixin(@RequestBody LoginAuthParamVO loginAuthParamVO) throws WxErrorException {
        return Result.success(wechatAuthService.login(loginAuthParamVO));
    }

    @PostMapping("{userId}/token")
    @ApiOperation("开发调试用的接口，生产环境不可用")
    public Result<String> getTokenByUserId(String userId) {
        User user = userApi.queryById(userId).getData();
        //生成token
        String token = JwtHelper.createJWT("wechat", JsonUtils.getInstance().obj2json(user), WechatConstants.JWT_TTL);
        return Result.success(token);
    }

}
