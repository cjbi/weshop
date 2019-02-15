package tech.wetech.weshop.marketing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.po.SearchHistory;
import tech.wetech.weshop.service.IService;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/searchHistory")
@FeignClient(value = "weshop-marketing-service")
public interface SearchHistoryService extends IService<SearchHistory> {

}
