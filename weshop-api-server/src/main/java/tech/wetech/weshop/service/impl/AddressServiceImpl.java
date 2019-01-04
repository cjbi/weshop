package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.AddressMapper;
import tech.wetech.weshop.mapper.RegionMapper;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.service.AddressService;
import tech.wetech.weshop.vo.AddressVO;

import java.util.Optional;

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
        Address checkedAddress = Optional.ofNullable(addressMapper.selectByPrimaryKey(id)).orElseGet(() -> new Address());
        AddressVO addressVO = new AddressVO(checkedAddress)
                .setProvinceName(
                        regionMapper.selectNameById(checkedAddress.getProvinceId().intValue())
                )
                .setCityName(
                        regionMapper.selectNameById(checkedAddress.getProvinceId().intValue())
                )
                .setDistrictName(
                        regionMapper.selectNameById(checkedAddress.getDistrictId().intValue())
                );

        addressVO.setFullRegion(
                addressVO.getProvinceName() + addressVO.getCityName() + addressVO.getDistrictName()
        );

        return addressVO;
    }
}
