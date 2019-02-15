package tech.wetech.weshop.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.user.service.AddressService;

import java.util.List;

@RestController
public class AddressController extends BaseApi<Address> implements AddressApi {

    @Autowired
    private AddressService addressService;

    @Override
    public AddressDTO queryDetail(Integer id) {
        return addressService.queryDetail(id);
    }

    @Override
    public List<AddressDTO> queryDetailList() {
        return addressService.queryDetailList();
    }
}
