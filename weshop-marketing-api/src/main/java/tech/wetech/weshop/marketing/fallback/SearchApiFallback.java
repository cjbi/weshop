package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultCodeEnum;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.SearchApi;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;

import java.util.List;

@Component
public class SearchApiFallback implements SearchApi {
    @Override
    public Result<List<String>> helper(String keyword) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result clearHistory() {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<SearchIndexDTO> index() {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }
}
