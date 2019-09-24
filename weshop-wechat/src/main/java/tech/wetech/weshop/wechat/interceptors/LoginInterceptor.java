package tech.wetech.weshop.wechat.interceptors;

import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import tech.wetech.weshop.common.utils.StringUtils;
import tech.wetech.weshop.wechat.constants.WechatConstants;
import tech.wetech.weshop.wechat.enums.WeshopWechatResultStatus;
import tech.wetech.weshop.wechat.exception.WeshopWechatException;
import tech.wetech.weshop.wechat.utils.JwtHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cjbi
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(WechatConstants.JWT_KEY_NAME);
        if (StringUtils.isBlank(token)) {
            throw new WeshopWechatException(WeshopWechatResultStatus.WECHAT_LOGIN_ERROR);
        }
        Claims claims = JwtHelper.parseJWT(token);
        JwtHelper.setCurrentClaims(claims);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        JwtHelper.setCurrentClaims(null);
    }
}
