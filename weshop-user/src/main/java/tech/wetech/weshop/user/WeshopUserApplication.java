package tech.wetech.weshop.user;

import org.springframework.boot.SpringApplication;
import tech.wetech.weshop.common.annotations.WeshopDalSpringCloudApplication;

@WeshopDalSpringCloudApplication
public class WeshopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopUserApplication.class, args);
    }

}
