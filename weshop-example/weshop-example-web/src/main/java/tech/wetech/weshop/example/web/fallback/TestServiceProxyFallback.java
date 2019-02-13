package tech.wetech.weshop.example.web.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.example.web.proxy.TestServiceProxy;

@Component
public class TestServiceProxyFallback implements TestServiceProxy {
    @Override
    public String sayHello(String name) {
        return "服务不可用！";
    }
}
