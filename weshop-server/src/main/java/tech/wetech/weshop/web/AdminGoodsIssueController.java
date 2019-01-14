package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.GoodsIssue;
import tech.wetech.weshop.web.base.BaseCrudController;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/goods-issue")
public class AdminGoodsIssueController extends BaseCrudController<GoodsIssue> {

}
