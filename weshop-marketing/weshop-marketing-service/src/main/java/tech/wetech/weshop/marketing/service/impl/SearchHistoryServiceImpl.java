package tech.wetech.weshop.marketing.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.marketing.po.SearchHistory;
import tech.wetech.weshop.marketing.service.SearchHistoryService;
import tech.wetech.weshop.service.BaseService;

/**
 * @author cjbi@outlook.com
 */
@RestController
public class SearchHistoryServiceImpl extends BaseService<SearchHistory> implements SearchHistoryService {
}
