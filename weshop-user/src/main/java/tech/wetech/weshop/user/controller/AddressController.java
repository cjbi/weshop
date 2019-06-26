package tech.wetech.weshop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.po.Address;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseApi<Address> implements AddressApi {
}
