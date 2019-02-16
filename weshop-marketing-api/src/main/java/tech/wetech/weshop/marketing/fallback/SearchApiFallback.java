package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.marketing.api.SearchApi;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@Component
public class SearchApiFallback implements SearchApi {
    @Override
    public Result<List<String>> helper(String keyword) {
        return null;
    }

    @Override
    public Result clearHistory() {
        return null;
    }

    @Override
    public Result<SearchIndexDTO> index() {
        return null;
    }
}
