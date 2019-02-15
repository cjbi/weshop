package tech.wetech.weshop.goods.client;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.user.service.CollectService;

@FeignClient(value = "weshop-user-service")
public interface CollectClient extends CollectService {
}
