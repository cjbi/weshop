package tech.wetech.weshop.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.user.service.RegionService;

@FeignClient(value = "weshop-user-service")
public interface RegionServiceProxy extends RegionService {
}
