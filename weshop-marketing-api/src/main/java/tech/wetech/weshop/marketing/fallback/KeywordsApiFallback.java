package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultCodeEnum;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.KeywordsApi;
import tech.wetech.weshop.marketing.po.Keywords;

import java.util.List;

@Component
public class KeywordsApiFallback extends ApiFallback<Keywords> implements KeywordsApi {
    @Override
    public Result<List<String>> queryByKeyword(String keyword) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }
}
