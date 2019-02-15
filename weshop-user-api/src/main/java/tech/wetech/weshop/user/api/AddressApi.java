package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;

import java.util.List;

@RequestMapping("/address")
@FeignClient(value = "weshop-user")
public interface AddressApi extends Api<Address> {

    @GetMapping("/queryDetail")
    AddressDTO queryDetail(Integer id);

    @GetMapping("/queryDetailList")
    List<AddressDTO> queryDetailList();
}
