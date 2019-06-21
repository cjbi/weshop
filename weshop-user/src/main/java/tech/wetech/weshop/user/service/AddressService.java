package tech.wetech.weshop.user.service;

import tech.wetech.weshop.common.service.IService;
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
