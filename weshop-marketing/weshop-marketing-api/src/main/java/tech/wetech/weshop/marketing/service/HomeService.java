package tech.wetech.weshop.marketing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;

@RequestMapping("/home")
@FeignClient(value = "weshop-marketing-service")
public interface HomeService {

    @GetMapping("/index")
    HomeIndexDTO index();

}
