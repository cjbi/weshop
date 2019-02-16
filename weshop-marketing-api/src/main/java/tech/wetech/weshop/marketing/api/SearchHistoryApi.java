package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.po.SearchHistory;

@FeignClient(value = "weshop-marketing", path = "searchHistory")
public interface SearchHistoryApi extends Api<SearchHistory> {
}
