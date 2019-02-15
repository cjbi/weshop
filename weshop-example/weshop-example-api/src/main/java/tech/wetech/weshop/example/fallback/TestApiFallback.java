package tech.wetech.weshop.example.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.example.api.TestApi;
@Component
public class TestApiFallback implements TestApi {
    @Override
    public String sayHello(String name) {
        return "service is invalid!";
    }
}
