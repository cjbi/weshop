package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultCodeEnum;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.HomeApi;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;

@Component
public class HomeApiFallback implements HomeApi {
    @Override
    public Result<HomeIndexDTO> index() {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }
}
