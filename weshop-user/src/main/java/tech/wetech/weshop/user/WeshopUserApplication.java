package tech.wetech.weshop.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan("tech.wetech.weshop")
@MapperScan(basePackages = "tech.wetech.weshop.user.mapper")
public class WeshopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopUserApplication.class, args);
    }

}
