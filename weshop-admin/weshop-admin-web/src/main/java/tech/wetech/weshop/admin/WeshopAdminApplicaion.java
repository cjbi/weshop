package tech.wetech.weshop.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cjbi@outlook.com
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@EnableWebMvc
public class WeshopAdminApplicaion {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(WeshopAdminApplicaion.class, args);
    }

}
