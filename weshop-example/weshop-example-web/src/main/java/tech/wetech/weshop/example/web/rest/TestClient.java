package tech.wetech.weshop.example.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.example.service.TestService;
import tech.wetech.weshop.example.web.fallback.TestClientFallback;

@FeignClient(value = "weshop-example-service", fallback = TestClientFallback.class)
public interface TestClient extends TestService {

}
