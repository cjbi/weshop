package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.po.Ad;

@RequestMapping("/ad")
@FeignClient("weshop-topic-service")
public interface AdApi extends Api<Ad> {
}
