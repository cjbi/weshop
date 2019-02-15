package tech.wetech.weshop.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.example.api.Test2Api;
import tech.wetech.weshop.example.service.TestService;

@RestController
public class Test2ApiImpl implements Test2Api {

    @Autowired
    TestService testService;

    @Override
    public String sayHello(String name) {
        return testService.sayHello(name);
    }
}
