package tech.wetech.weshop.admin.service;

import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.admin.dto.AddressDTO;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface AddressService extends IService<Address> {

    AddressDTO queryDetail(Integer id);

    List<AddressDTO> queryDetailList();

}
