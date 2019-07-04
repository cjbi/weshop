package tech.wetech.weshop.wechat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.wetech.weshop.wechat.interceptors.LoginInterceptor;

@Configuration
public class WechatWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有的路径
                .excludePathPatterns(//配置不需要登陆的接口
                        "/",
                        "/csrf",
                        "/error",
                        "/favicon.ico",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui.html/**",
                        "/wechat/brand/**",
                        "/wechat/catalog/**",
                        "/wechat/goods/**",
                        "/wechat/home/**",
                        "/wechat/search/**",
                        "/wechat/topic/**",
                        "/wechat/auth/loginByWeixin",
                        "/wechat/dev/{userId}/token"

                );
    }
}
