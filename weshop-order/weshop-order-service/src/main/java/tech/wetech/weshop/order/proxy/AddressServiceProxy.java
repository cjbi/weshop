package tech.wetech.weshop.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.user.service.AddressService;

@FeignClient(value = "weshop-user-service")
public interface AddressServiceProxy extends AddressService {

}
