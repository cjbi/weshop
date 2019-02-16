package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.po.Region;
import tech.wetech.weshop.utils.Result;

@Component
public class RegionApiFallback extends ApiFallback<Region> implements RegionApi {
    @Override
    public Result<String> queryNameById(Short id) {
        return null;
    }
}
