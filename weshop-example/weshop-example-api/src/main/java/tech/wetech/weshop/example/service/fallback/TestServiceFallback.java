package tech.wetech.weshop.example.service.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.example.service.TestService;
@Component
public class TestServiceFallback implements TestService {
    @Override
    public String sayHello(String name) {
        return "service is invalid!";
    }
}
