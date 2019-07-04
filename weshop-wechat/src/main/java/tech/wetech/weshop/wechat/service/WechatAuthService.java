package tech.wetech.weshop.wechat.service;

import me.chanjar.weixin.common.error.WxErrorException;
import tech.wetech.weshop.wechat.vo.LoginAuthParamVO;
import tech.wetech.weshop.wechat.vo.LoginAuthResultVO;

public interface WechatAuthService {

    /**
     * 登陆接口
     *
     * @param loginAuthParamVO
     * @return
     */
    LoginAuthResultVO login(LoginAuthParamVO loginAuthParamVO) throws WxErrorException;

}
