package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.marketing.api.HomeApi;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;
import tech.wetech.weshop.utils.Result;

@Component
public class HomeApiFallback implements HomeApi {
    @Override
    public Result<HomeIndexDTO> index() {
        return null;
    }
}
