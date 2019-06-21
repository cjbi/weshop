package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;
import tech.wetech.weshop.marketing.fallback.HomeApiFallback;

@FeignClient(value = "weshop-marketing", path = "home", fallback = HomeApiFallback.class)
public interface HomeApi {

    @GetMapping("/index")
    Result<HomeIndexDTO> index();
}
