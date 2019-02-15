package tech.wetech.weshop.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.wetech.weshop.example.service.fallback.TestServiceFallback;

@FeignClient(value = "weshop-example-service")
public interface TestService {

    @GetMapping("/hello/{name}")
    String sayHello(@PathVariable String name);

}
