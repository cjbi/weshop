package tech.wetech.weshop.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan("tech.wetech.weshop")
@EnableFeignClients("tech.wetech.weshop.*.api")
public class WeshopPayApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeshopPayApplication.class, args);
  }

}
