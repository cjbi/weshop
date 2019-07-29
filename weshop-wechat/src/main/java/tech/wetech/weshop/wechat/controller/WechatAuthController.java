package tech.wetech.weshop.wechat.controller;

import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.wechat.service.WechatAuthService;
import tech.wetech.weshop.wechat.vo.LoginAuthParamVO;
import tech.wetech.weshop.wechat.vo.LoginAuthResultVO;

@RestController
@RequestMapping("/wechat/auth")
public class WechatAuthController extends BaseController {

    @Autowired
    private WechatAuthService wechatAuthService;

    @PostMapping("/login")
    public Result<LoginAuthResultVO> loginByWeixin(@RequestBody @Validated LoginAuthParamVO loginAuthParamVO) throws WxErrorException {
        return Result.success(wechatAuthService.login(loginAuthParamVO));
    }

}
