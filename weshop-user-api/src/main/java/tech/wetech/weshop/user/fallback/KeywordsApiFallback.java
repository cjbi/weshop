package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.KeywordsApi;
import tech.wetech.weshop.user.po.Keywords;

import java.util.List;

@Component
public class KeywordsApiFallback extends ApiFallback<Keywords> implements KeywordsApi {
    @Override
    public Result<List<String>> queryByKeyword(String keyword) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
