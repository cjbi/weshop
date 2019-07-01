package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.po.Region;

@Component
public class RegionApiFallback extends ApiFallback<Region> implements RegionApi {
    @Override
    public Result<String> queryNameById(Short id) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
