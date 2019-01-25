package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.wechat.service.AddressService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.wechat.dto.AddressDTO;
import tech.wetech.weshop.web.BaseController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/address")
@Validated
public class WechatAddressController extends BaseController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public Result<List<AddressDTO>> queryList() {
        return Result.success(addressService.queryDetailList());
    }

    @GetMapping("/detail")
    public Result<AddressDTO> queryDetail(@NotNull Integer id) {
        return Result.success(addressService.queryDetail(id));
    }

    @PostMapping("/create")
    public Result create(@Validated @RequestBody Address entity) {
        entity.setUserId(Constants.CURRENT_USER_ID);
        addressService.create(entity);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody Address entity) {
        entity.setUserId(Constants.CURRENT_USER_ID);
        addressService.updateNotNull(entity);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(@NotNull Object id) {
        addressService.deleteById(id);
        return Result.success();
    }
}
