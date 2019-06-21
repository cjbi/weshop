package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.marketing.api.SearchHistoryApi;
import tech.wetech.weshop.marketing.po.SearchHistory;

@Component
public class SearchHistoryApiFallback extends ApiFallback<SearchHistory> implements SearchHistoryApi {
}
