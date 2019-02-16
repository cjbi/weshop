package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.po.Region;

@FeignClient(value = "weshop-user", path = "region")
public interface RegionApi extends Api<Region> {

    @RequestMapping(value = "/queryNameById", method = RequestMethod.GET)
    String queryNameById(Short id);
}
