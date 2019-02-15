package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.po.Region;

@RequestMapping("/region")
@FeignClient(value = "weshop-user")
public interface RegionApi extends Api<Region> {

    @GetMapping("/queryNameById")
    String queryNameById(Short id);
}
