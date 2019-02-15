package tech.wetech.weshop.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan("tech.wetech.weshop")
@MapperScan(basePackages = "tech.wetech.weshop.goods.mapper")
@EnableFeignClients(basePackages = {
        "tech.wetech.weshop.user.api",
        "tech.wetech.weshop.marketing.api",
        "tech.wetech.weshop.order.api"
})
public class WeshopGoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopGoodsServiceApplication.class, args);
    }

}
