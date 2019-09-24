package tech.wetech.weshop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cjbi@outlook.com
 */
@SpringCloudApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan("tech.wetech.weshop")
@EnableFeignClients("tech.wetech.weshop.*.api")
public class WeshopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopAdminApplication.class, args);
    }

}
