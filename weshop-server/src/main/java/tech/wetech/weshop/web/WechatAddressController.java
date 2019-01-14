package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.service.AddressService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.AddressVO;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/address")
@Validated
public class WechatAddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public Result<List<AddressVO>> queryList() {
        return Result.success(addressService.queryDetailList());
    }

    @GetMapping("/detail")
    public Result<AddressVO> queryDetail(@NotNull Integer id) {
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
