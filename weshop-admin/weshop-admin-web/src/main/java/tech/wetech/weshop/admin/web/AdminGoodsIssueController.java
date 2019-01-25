package tech.wetech.weshop.admin.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.GoodsIssue;
import tech.wetech.weshop.web.BaseCrudController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/goods-issue")
public class AdminGoodsIssueController extends BaseCrudController<GoodsIssue> {

}
