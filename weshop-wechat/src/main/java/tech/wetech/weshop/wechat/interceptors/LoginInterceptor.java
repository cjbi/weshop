package tech.wetech.weshop.wechat.interceptors;

import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.exception.BizException;
import tech.wetech.weshop.common.utils.StringUtils;
import tech.wetech.weshop.wechat.utils.JwtHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cjbi
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("X-Weshop-Token");
        if (StringUtils.isBlank(token)) {
            throw new BizException(ResultStatus.WECHAT_LOGIN_ERROR);
        }
        Claims claims = JwtHelper.parseJWT(token);
        JwtHelper.setCurrentClaims(claims);
        return true;
    }
}
