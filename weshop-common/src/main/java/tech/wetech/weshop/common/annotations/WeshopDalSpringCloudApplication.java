package tech.wetech.weshop.common.annotations;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tech.wetech.weshop.common.config.WeshopAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

import java.lang.annotation.*;

/**
 * @author cjbi
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringCloudApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan(value = "tech.wetech.weshop")
@EnableFeignClients("tech.wetech.weshop.*.api")
@EnableCaching
@MapperScan(basePackages = "tech.wetech.weshop.*.mapper")
@ImportAutoConfiguration(WeshopAutoConfiguration.class)
public @interface WeshopDalSpringCloudApplication {

}
