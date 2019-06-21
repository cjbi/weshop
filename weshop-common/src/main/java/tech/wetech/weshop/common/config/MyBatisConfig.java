package tech.wetech.weshop.common.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = "tech.wetech.weshop.*.mapper")
public class MyBatisConfig {

}
