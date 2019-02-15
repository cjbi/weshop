package tech.wetech.weshop.goods.client;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.user.service.UserService;

@FeignClient(value = "weshop-user-service")
public interface UserClient extends UserService {
}
