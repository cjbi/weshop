package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.vo.AddressVO;

/**
 * @author cjbi
 */
public interface AddressService extends IService<Address> {

    AddressVO queryDetail(Integer id);

}
