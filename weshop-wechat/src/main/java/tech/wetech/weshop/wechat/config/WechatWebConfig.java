package tech.wetech.weshop.wechat.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.wetech.weshop.wechat.interceptors.LoginInterceptor;


@Configuration
@EnableConfigurationProperties(WeshopWechatProperties.class)
public class WechatWebConfig implements WebMvcConfigurer {

    private final WeshopWechatProperties weshopWechatProperties;

    public WechatWebConfig(WeshopWechatProperties weshopWechatProperties) {
        this.weshopWechatProperties = weshopWechatProperties;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有的路径
                .excludePathPatterns(weshopWechatProperties.getLoginInterceptorExcludePath().toArray(new String[]{}));
    }
}
