package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;

@FeignClient("weshop-topic-service")
@RequestMapping("/home")
public interface HomeApi {

    @GetMapping("/index")
    HomeIndexDTO index();
}
