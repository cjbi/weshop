package tech.wetech.weshop.wechat.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.common.utils.EnumUtils;
import tech.wetech.weshop.common.utils.JsonUtils;
import tech.wetech.weshop.common.utils.WebUtil;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.enums.GenderEnum;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.config.WxMaConfiguration;
import tech.wetech.weshop.wechat.constants.WechatConstants;
import tech.wetech.weshop.wechat.service.WechatAuthService;
import tech.wetech.weshop.wechat.utils.JwtHelper;
import tech.wetech.weshop.wechat.vo.LoginAuthParamVO;
import tech.wetech.weshop.wechat.vo.LoginAuthResultVO;

import java.util.Date;
import java.util.UUID;

@Service
public class WechatAuthServiceImpl implements WechatAuthService {

    @Value("${weshop.wx.miniapp.appid}")
    private String appid;

    @Autowired
    private UserApi userApi;

    @Override
    public LoginAuthResultVO login(LoginAuthParamVO loginAuthParamVO) throws WxErrorException {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        WxMaJscode2SessionResult sessionInfo = wxService.getUserService().getSessionInfo(loginAuthParamVO.getCode());
        LoginAuthParamVO.UserInfoX.UserInfo userInfo = loginAuthParamVO.getUserInfo().getUserInfo();
        //根据openId查询用户是否已经注册
        User user = userApi.queryOneByCriteria(Criteria.of(User.class).andEqualTo(User::getWechatOpenId, sessionInfo.getOpenid())).getData();
        if (user == null) {
            //注册
            user = new User();
            user.setUsername("微信用户" + UUID.randomUUID().toString());
            user.setPassword("");
            user.setRegisterTime(new Date());
            user.setRegisterIp(WebUtil.getInstance().getIpAddress());
            user.setMobile("");
            user.setWechatOpenId(sessionInfo.getOpenid());
            user.setAvatar(userInfo.getAvatarUrl());
            user.setGender(EnumUtils.getEnum(GenderEnum.class, userInfo.getGender()));
            user.setNickname(userInfo.getNickName());
            userApi.create(user);
        }
        //查询用户信息
        User newUser = userApi.queryOneByCriteria(Criteria.of(User.class).andEqualTo(User::getWechatOpenId, sessionInfo.getOpenid())).getData();
        newUser.setLastLoginTime(new Date());
        newUser.setLastLoginIp(WebUtil.getInstance().getIpAddress());
        //更新登陆信息
        userApi.updateNotNull(newUser);
        //生成token
        String token = JwtHelper.createJWT("wechat", JsonUtils.toJson(newUser), WechatConstants.JWT_TTL);
        return new LoginAuthResultVO(token, newUser);
    }
}
