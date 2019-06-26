package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.utils.Constants;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.wechat.service.WechatAddressService;
import tech.wetech.weshop.wechat.vo.AddressVO;

import java.util.LinkedList;
import java.util.List;

@Service
public class WechatAddressServiceImpl implements WechatAddressService {

    @Autowired
    private AddressApi addressApi;

    @Autowired
    private RegionApi regionApi;

    @Override
    public AddressVO queryDetail(Integer id) {
        Address address = addressApi.queryById(id).getData();
        AddressVO addressDTO = null;
        if (address != null) {
            addressDTO = new AddressVO(address)
                    .setProvinceName(
                            regionApi.queryNameById(address.getProvinceId()).getData()
                    )
                    .setCityName(
                            regionApi.queryNameById(address.getCityId()).getData()
                    )
                    .setDistrictName(
                            regionApi.queryNameById(address.getDistrictId()).getData()
                    );

            addressDTO.setFullRegion(
                    addressDTO.getProvinceName() + addressDTO.getCityName() + addressDTO.getDistrictName()
            );
        }
        return addressDTO;
    }

    @Override
    public List<AddressVO> queryDetailList() {
        List<Address> addressList = addressApi.queryList(new Address().setUserId(Constants.CURRENT_USER_ID)).getData();
        LinkedList<AddressVO> addressDTOList = new LinkedList<>();
        for (Address address : addressList) {
            AddressVO addressDTO = new AddressVO(address)
                    .setProvinceName(
                            regionApi.queryNameById(address.getProvinceId()).getData()
                    )
                    .setCityName(
                            regionApi.queryNameById(address.getCityId()).getData()
                    )
                    .setDistrictName(
                            regionApi.queryNameById(address.getDistrictId()).getData()
                    );
            addressDTO.setFullRegion(
                    addressDTO.getProvinceName() + addressDTO.getCityName() + addressDTO.getDistrictName()
            );
            addressDTOList.add(addressDTO);
        }
        return addressDTOList;
    }
}
