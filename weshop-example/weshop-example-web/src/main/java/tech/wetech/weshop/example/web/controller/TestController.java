package tech.wetech.weshop.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.example.web.rest.TestClient;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private TestClient testClient;

    @Value("${from}")
    private String from;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return testClient.sayHello(name);
    }

    @GetMapping("/from")
    public String from() {
        return this.from;
    }

}
