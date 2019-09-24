package tech.wetech.weshop.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableZuulProxy
@EnableWebMvc
@EnableSwagger2
@ComponentScan("tech.wetech.weshop")
@SpringCloudApplication
public class WeshopApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeshopApiGatewayApplication.class, args);
    }

    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
          resources.add(swaggerResource("weshop-wechat", "/weshop-wechat/v2/api-docs", "1.0"));
          resources.add(swaggerResource("weshop-admin", "/weshop-admin/v2/api-docs", "1.0"));
          resources.add(swaggerResource("weshop-goods", "/weshop-goods/v2/api-docs", "1.0"));
          resources.add(swaggerResource("weshop-user", "/weshop-user/v2/api-docs", "1.0"));
          resources.add(swaggerResource("weshop-order", "/weshop-order/v2/api-docs", "1.0"));
          resources.add(swaggerResource("weshop-pay", "/weshop-pay/v2/api-docs", "1.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}

