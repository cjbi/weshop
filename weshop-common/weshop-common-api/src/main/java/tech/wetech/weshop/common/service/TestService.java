package tech.wetech.weshop.common.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface TestService {

    @GetMapping("/hello/{name}")
    String sayHello(@PathVariable String name);

}
