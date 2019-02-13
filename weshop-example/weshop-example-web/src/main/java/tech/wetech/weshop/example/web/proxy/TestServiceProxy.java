package tech.wetech.weshop.example.web.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.example.service.TestService;
import tech.wetech.weshop.example.web.fallback.TestServiceProxyFallback;

@FeignClient(value = "weshop-example-service", fallback = TestServiceProxyFallback.class)
public interface TestServiceProxy extends TestService {

}
