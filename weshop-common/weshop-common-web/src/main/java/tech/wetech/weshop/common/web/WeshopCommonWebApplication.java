package tech.wetech.weshop.common.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class WeshopCommonWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopCommonWebApplication.class, args);
    }
}
