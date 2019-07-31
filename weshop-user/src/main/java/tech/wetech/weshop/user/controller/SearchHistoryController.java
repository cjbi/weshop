package tech.wetech.weshop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.user.api.SearchHistoryApi;
import tech.wetech.weshop.user.po.SearchHistory;

@RestController
@RequestMapping("/searchHistory")
public class SearchHistoryController extends BaseApi<SearchHistory> implements SearchHistoryApi {
}
