package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.wechat.vo.AddressVO;

import java.util.List;

public interface WechatAddressService {

    AddressVO queryDetail(Integer id);

    List<AddressVO> queryDetailList();

}
