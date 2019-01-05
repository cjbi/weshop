package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.AddressMapper;
import tech.wetech.weshop.mapper.RegionMapper;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.service.AddressService;
import tech.wetech.weshop.vo.AddressVO;

/**
 * @author cjbi
 */
@Service
public class AddressServiceImpl extends BaseService<Address> implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public AddressVO queryDetail(Integer id) {
        Address address = addressMapper.selectByPrimaryKey(id);
        AddressVO addressVO = null;
        if (address != null) {
            addressVO = new AddressVO(address)
                    .setProvinceName(
                            regionMapper.selectNameById(address.getProvinceId())
                    )
                    .setCityName(
                            regionMapper.selectNameById(address.getProvinceId())
                    )
                    .setDistrictName(
                            regionMapper.selectNameById(address.getDistrictId())
                    );

            addressVO.setFullRegion(
                    addressVO.getProvinceName() + addressVO.getCityName() + addressVO.getDistrictName()
            );
        }
        return addressVO;
    }
}
