package tech.wetech.weshop.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WeshopEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeshopEurekaServerApplication.class, args);
	}

}