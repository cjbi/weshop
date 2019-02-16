package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;

import java.util.List;

@FeignClient(value = "weshop-user", path = "address")
public interface AddressApi extends Api<Address> {

    @RequestMapping(value = "/queryDetail", method = RequestMethod.GET)
    AddressDTO queryDetail(Integer id);

    @RequestMapping(value = "/queryDetailList", method = RequestMethod.GET)
    List<AddressDTO> queryDetailList();
}
