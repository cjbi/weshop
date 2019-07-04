package tech.wetech.weshop.order;

import org.springframework.boot.SpringApplication;
import tech.wetech.weshop.common.annotations.WeshopDataSourceSpringCloudApplication;

@WeshopDataSourceSpringCloudApplication
public class WeshopOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopOrderApplication.class, args);
    }
}
