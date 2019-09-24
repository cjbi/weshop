package tech.wetech.weshop.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan(value = "tech.wetech.weshop")
@EnableFeignClients("tech.wetech.weshop.*.api")
@EnableCaching
@MapperScan(basePackages = "tech.wetech.weshop.*.mapper")
public class WeshopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopUserApplication.class, args);
    }

}
