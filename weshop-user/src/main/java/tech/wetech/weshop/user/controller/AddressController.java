package tech.wetech.weshop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.user.service.AddressService;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseApi<Address> implements AddressApi {

    @Autowired
    private AddressService addressService;

    @Override
    public Result<AddressDTO> queryDetail(Integer id) {
        return Result.success(addressService.queryDetail(id));
    }

    @Override
    public Result<List<AddressDTO>> queryDetailList() {
        return Result.success(addressService.queryDetailList());
    }
}
