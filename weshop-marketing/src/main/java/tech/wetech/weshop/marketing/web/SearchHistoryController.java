package tech.wetech.weshop.marketing.web;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.marketing.api.SearchHistoryApi;
import tech.wetech.weshop.marketing.po.SearchHistory;

@RestController
public class SearchHistoryController extends BaseApi<SearchHistory> implements SearchHistoryApi {
}
