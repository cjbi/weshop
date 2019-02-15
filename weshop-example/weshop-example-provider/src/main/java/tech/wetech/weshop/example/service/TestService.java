package tech.wetech.weshop.example.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface TestService {

    String sayHello(@PathVariable String name);

}
