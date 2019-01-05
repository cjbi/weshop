package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.AddressService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.AddressVO;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/address")
public class WechatAddressController extends BaseController<Address> {

    @Autowired
    private AddressService addressService;

    @Override
    public Result queryList(Address entity, PageQuery pageQuery) {
        entity.setUserId(Constants.CURRENT_USER_ID);
        return super.queryList(entity, pageQuery);
    }

    @Override
    public Result query(Object id) {
        return super.query(id);
    }

    @GetMapping("/detail")
    public Result<AddressVO> queryDetail(Integer id) {
        return Result.success(addressService.queryDetail(id));
    }

    @Override
    public Result create(Address entity) {
        entity.setUserId(Constants.CURRENT_USER_ID);
        return super.create(entity);
    }

    @Override
    public Result update(Address entity) {
        entity.setUserId(Constants.CURRENT_USER_ID);
        return super.update(entity);
    }

    @Override
    public Result delete(Object id) {
        return super.delete(id);
    }

    @Override
    public Result deleteBatchIds(@NotNull Object[] ids) {
        return super.deleteBatchIds(ids);
    }
}
