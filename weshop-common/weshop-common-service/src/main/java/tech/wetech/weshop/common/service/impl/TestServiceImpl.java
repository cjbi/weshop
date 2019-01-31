package tech.wetech.weshop.common.service.impl;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.service.TestService;

@RestController
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

}
