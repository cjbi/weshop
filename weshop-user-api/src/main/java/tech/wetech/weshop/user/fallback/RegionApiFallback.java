package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.po.Region;

@Component
public class RegionApiFallback extends ApiFallback<Region> implements RegionApi {
    @Override
    public ResultWrapper<String> queryNameById(Short id) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
