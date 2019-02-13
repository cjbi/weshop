package tech.wetech.weshop.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${aaa}")
    private String aaa;

    @GetMapping("/from")
    public String from() {
        return this.aaa;
    }

}
