package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.po.Address;

@Component
public class AddressApiFallback extends ApiFallback<Address> implements AddressApi {

}
