package tech.wetech.weshop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.common.utils.Constants;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.mapper.AddressMapper;
import tech.wetech.weshop.user.mapper.RegionMapper;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.user.service.AddressService;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RestController
public class AddressServiceImpl extends BaseService<Address> implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public AddressDTO queryDetail(Integer id) {
        Address address = addressMapper.selectByPrimaryKey(id);
        AddressDTO addressDTO = null;
        if (address != null) {
            addressDTO = new AddressDTO(address)
                    .setProvinceName(
                            regionMapper.selectNameById(address.getProvinceId())
                    )
                    .setCityName(
                            regionMapper.selectNameById(address.getCityId())
                    )
                    .setDistrictName(
                            regionMapper.selectNameById(address.getDistrictId())
                    );

            addressDTO.setFullRegion(
                    addressDTO.getProvinceName() + addressDTO.getCityName() + addressDTO.getDistrictName()
            );
        }
        return addressDTO;
    }

    @Override
    public List<AddressDTO> queryDetailList() {
        List<Address> addressList = addressMapper.select(new Address().setUserId(Constants.CURRENT_USER_ID));
        LinkedList<AddressDTO> addressDTOList = new LinkedList<>();
        for (Address address : addressList) {
            AddressDTO addressDTO = new AddressDTO(address)
                    .setProvinceName(
                            regionMapper.selectNameById(address.getProvinceId())
                    )
                    .setCityName(
                            regionMapper.selectNameById(address.getCityId())
                    )
                    .setDistrictName(
                            regionMapper.selectNameById(address.getDistrictId())
                    );
            addressDTO.setFullRegion(
                    addressDTO.getProvinceName() + addressDTO.getCityName() + addressDTO.getDistrictName()
            );
            addressDTOList.add(addressDTO);
        }
        return addressDTOList;
    }
}
