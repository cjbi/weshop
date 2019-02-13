package tech.wetech.weshop.example.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.example.service.TestService;

@RestController
public class TestServiceImpl implements TestService {

    @Override
    @HystrixCommand
    public String sayHello(String name) {
        return "hello " + name;
    }

}
