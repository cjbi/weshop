package tech.wetech.weshop.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WeshopDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeshopDiscoveryServerApplication.class, args);
	}

}