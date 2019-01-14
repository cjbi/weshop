package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.web.base.BaseCrudController;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/keywords")
public class AdminKeywordsController extends BaseCrudController<Keywords> {

}
