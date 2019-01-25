package tech.wetech.weshop.admin.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.SearchHistory;
import tech.wetech.weshop.web.BaseCrudController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/search-history")
public class AdminSearchHistoryController extends BaseCrudController<SearchHistory> {

}
