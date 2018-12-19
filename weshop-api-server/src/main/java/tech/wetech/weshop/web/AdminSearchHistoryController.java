package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.SearchHistory;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/search-history")
public class AdminSearchHistoryController extends BaseController<SearchHistory> {

}
