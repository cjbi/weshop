package tech.wetech.weshop.example.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.wetech.weshop.example.fallback.Test2ApiFallback;

@FeignClient(value = "weshop-example-provider", fallback = Test2ApiFallback.class)
public interface Test2Api {

    @GetMapping("/hello2/{name}")
    String sayHello(@PathVariable String name);

}