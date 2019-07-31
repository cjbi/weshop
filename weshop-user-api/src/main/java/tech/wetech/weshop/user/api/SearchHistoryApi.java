package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.fallback.SearchHistoryApiFallback;
import tech.wetech.weshop.user.po.SearchHistory;

@FeignClient(value = "weshop-user", path = "searchHistory", fallback = SearchHistoryApiFallback.class)
public interface SearchHistoryApi extends Api<SearchHistory> {
}
