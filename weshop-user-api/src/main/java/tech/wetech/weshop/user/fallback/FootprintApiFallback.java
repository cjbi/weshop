package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.FootprintApi;
import tech.wetech.weshop.user.dto.GoodsFootprintDTO;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

@Component
public class FootprintApiFallback extends ApiFallback<Footprint> implements FootprintApi {

    @Override
    public ResultWrapper<List<GoodsFootprintDTO>> queryGoodsFootprintByUserId(Integer userId) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
