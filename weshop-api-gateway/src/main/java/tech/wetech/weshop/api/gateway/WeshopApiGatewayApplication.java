package tech.wetech.weshop.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class WeshopApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopApiGatewayApplication.class, args);
    }

}

