package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.GoodsIssue;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/goods-issue")
public class AdminGoodsIssueController extends BaseController<GoodsIssue> {

}
