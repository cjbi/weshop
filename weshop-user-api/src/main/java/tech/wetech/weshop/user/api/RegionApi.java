package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.fallback.RegionApiFallback;
import tech.wetech.weshop.user.po.Region;

@FeignClient(value = "weshop-user", path = "region", fallback = RegionApiFallback.class)
public interface RegionApi extends Api<Region> {

    @GetMapping("/queryNameById")
    Result<String> queryNameById(@RequestParam("id") Short id);
}
