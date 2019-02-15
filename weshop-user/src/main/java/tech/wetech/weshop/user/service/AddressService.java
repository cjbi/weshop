package tech.wetech.weshop.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface AddressService extends IService<Address> {

    AddressDTO queryDetail(Integer id);

    List<AddressDTO> queryDetailList();

}
