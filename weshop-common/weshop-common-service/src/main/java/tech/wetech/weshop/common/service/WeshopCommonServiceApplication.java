package tech.wetech.weshop.common.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeshopCommonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopCommonServiceApplication.class, args);
    }

}
