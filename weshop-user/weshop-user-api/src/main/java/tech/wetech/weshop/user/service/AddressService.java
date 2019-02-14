package tech.wetech.weshop.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/address")
public interface AddressService extends IService<Address> {

    @GetMapping("/queryDetail")
    AddressDTO queryDetail(Integer id);

    @GetMapping("/queryDetailList")
    List<AddressDTO> queryDetailList();

}
