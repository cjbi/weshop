package tech.wetech.weshop.example.web.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.example.web.rest.TestClient;

@Component
public class TestClientFallback implements TestClient {
    @Override
    public String sayHello(String name) {
        return "服务不可用！";
    }
}
