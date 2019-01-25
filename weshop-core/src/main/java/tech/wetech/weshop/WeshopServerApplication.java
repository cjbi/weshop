package tech.wetech.weshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
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
public class WeshopServerApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(WeshopServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>> weshop-api-server 服务启动完成!");
    }

}
