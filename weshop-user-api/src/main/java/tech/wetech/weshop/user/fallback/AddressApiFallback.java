package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultCodeEnum;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;

import java.util.List;

@Component
public class AddressApiFallback extends ApiFallback<Address> implements AddressApi {

    @Override
    public Result<AddressDTO> queryDetail(Integer id) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<List<AddressDTO>> queryDetailList() {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }
}
