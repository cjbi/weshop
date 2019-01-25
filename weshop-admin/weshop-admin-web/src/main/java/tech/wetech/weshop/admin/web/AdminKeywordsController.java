package tech.wetech.weshop.admin.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.web.BaseCrudController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/keywords")
public class AdminKeywordsController extends BaseCrudController<Keywords> {

}
