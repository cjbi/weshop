package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.fallback.RegionApiFallback;
import tech.wetech.weshop.user.po.Region;
import tech.wetech.weshop.utils.Result;

@FeignClient(value = "weshop-user", path = "region", fallback = RegionApiFallback.class)
public interface RegionApi extends Api<Region> {

    @GetMapping("/queryNameById")
    Result<String> queryNameById(Short id);
}
