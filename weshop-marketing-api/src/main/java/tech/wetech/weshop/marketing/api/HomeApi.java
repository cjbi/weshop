package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;

@FeignClient(value = "weshop-marketing", path = "home")
public interface HomeApi {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    HomeIndexDTO index();
}
