package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.fallback.AddressApiFallback;
import tech.wetech.weshop.user.po.Address;

@FeignClient(value = "weshop-user", path = "address", fallback = AddressApiFallback.class)
public interface AddressApi extends Api<Address> {

}
