package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Constants;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;

import java.util.List;

@RestController
@RequestMapping("/wechat/address")
@Validated
public class WechatAddressController extends BaseController {

    @Autowired
    private AddressApi addressApi;

    @GetMapping("/list")
    public Result<List<AddressDTO>> queryList() {
        return addressApi.queryDetailList();
    }

    @GetMapping("/detail")
    public Result<AddressDTO> queryDetail(Integer id) {
        return addressApi.queryDetail(id);
    }

    @PostMapping("/create")
    public Result create(@Validated @RequestBody Address entity) {
        entity.setUserId(Constants.CURRENT_USER_ID);
        return addressApi.create(entity);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody Address entity) {
        entity.setUserId(Constants.CURRENT_USER_ID);
        addressApi.updateNotNull(entity);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(Object id) {
        addressApi.deleteById(id);
        return Result.success();
    }
}
