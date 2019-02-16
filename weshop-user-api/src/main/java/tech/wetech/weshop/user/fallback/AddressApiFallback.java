package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@Component
public class AddressApiFallback extends ApiFallback<Address> implements AddressApi {

    @Override
    public Result<AddressDTO> queryDetail(Integer id) {
        return null;
    }

    @Override
    public Result<List<AddressDTO>> queryDetailList() {
        return null;
    }
}
