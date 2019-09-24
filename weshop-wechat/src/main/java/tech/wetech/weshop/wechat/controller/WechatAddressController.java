package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.service.WechatAddressService;
import tech.wetech.weshop.wechat.utils.JwtHelper;
import tech.wetech.weshop.wechat.vo.AddressVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/address")
@Validated
public class WechatAddressController extends BaseController {

    @Autowired
    private WechatAddressService addressService;

    @Autowired
    private AddressApi addressApi;

    @GetMapping("/list")
    public ResultWrapper<List<AddressVO>> queryList() {
        return ResultWrapper.success(addressService.queryDetailList());
    }

    @GetMapping("/detail")
    public ResultWrapper<AddressVO> queryDetail(Integer id) {
        return ResultWrapper.success(addressService.queryDetail(id));
    }

    @PostMapping("/save")
    public ResultWrapper save(@Validated @RequestBody Address entity) {
        User userInfo = JwtHelper.getUserInfo();
        entity.setUserId(userInfo.getId());
        return addressApi.create(entity);
    }

    @PostMapping("/update")
    public ResultWrapper update(@Validated @RequestBody Address entity) {
        User userInfo = JwtHelper.getUserInfo();
        entity.setUserId(userInfo.getId());
        addressApi.updateNotNull(entity);
        return ResultWrapper.success();
    }

    @PostMapping("/delete")
    public ResultWrapper delete(@Validated @RequestBody Address entity) {
        addressApi.deleteById(entity.getId());
        return ResultWrapper.success();
    }
}
