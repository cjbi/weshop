package tech.wetech.weshop.marketing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.po.Ad;
import tech.wetech.weshop.service.IService;

@RequestMapping("/ad")
@FeignClient(value = "weshop-marketing-service")
public interface AdService extends IService<Ad> {
}
