package tech.wetech.weshop.common.web.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.web.rest.TestClient;

@Component
public class TestClientFallback implements TestClient {
    @Override
    public String sayHello(String name) {
        return "服务不可用！";
    }
}
