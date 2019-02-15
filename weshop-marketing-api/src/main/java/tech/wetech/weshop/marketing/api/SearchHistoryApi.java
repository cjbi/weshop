package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.po.SearchHistory;

@RequestMapping("/searchHistory")
@FeignClient("weshop-marketing")
public interface SearchHistoryApi extends Api<SearchHistory> {
}
