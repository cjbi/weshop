package tech.wetech.weshop.common.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.web.rest.TestClient;

@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return testClient.sayHello(name);
    }

}
