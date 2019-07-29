package tech.wetech.weshop.wechat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "weshop-wechat")
public class WeshopWechatProperties {

    private List<String> loginInterceptorExcludePath;

    public List<String> getLoginInterceptorExcludePath() {
        return loginInterceptorExcludePath;
    }

    public void setLoginInterceptorExcludePath(List<String> loginInterceptorExcludePath) {
        this.loginInterceptorExcludePath = loginInterceptorExcludePath;
    }
}
