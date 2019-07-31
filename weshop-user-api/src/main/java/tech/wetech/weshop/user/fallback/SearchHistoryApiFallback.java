package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.user.api.SearchHistoryApi;
import tech.wetech.weshop.user.po.SearchHistory;

@Component
public class SearchHistoryApiFallback extends ApiFallback<SearchHistory> implements SearchHistoryApi {
}
