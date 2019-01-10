package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.AddressMapper;
import tech.wetech.weshop.mapper.RegionMapper;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.service.AddressService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.vo.AddressVO;

import java.util.LinkedList;
import java.util.List;

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
                            regionMapper.selectNameById(address.getCityId())
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

    @Override
    public List<AddressVO> queryDetailList() {
        List<Address> addressList = addressMapper.select(new Address().setUserId(Constants.CURRENT_USER_ID));
        LinkedList<AddressVO> addressVOList = new LinkedList<>();
        for (Address address : addressList) {
            AddressVO addressVO = new AddressVO(address)
                    .setProvinceName(
                            regionMapper.selectNameById(address.getProvinceId())
                    )
                    .setCityName(
                            regionMapper.selectNameById(address.getCityId())
                    )
                    .setDistrictName(
                            regionMapper.selectNameById(address.getDistrictId())
                    );
            addressVO.setFullRegion(
                    addressVO.getProvinceName() + addressVO.getCityName() + addressVO.getDistrictName()
            );
            addressVOList.add(addressVO);
        }
        return addressVOList;
    }
}
