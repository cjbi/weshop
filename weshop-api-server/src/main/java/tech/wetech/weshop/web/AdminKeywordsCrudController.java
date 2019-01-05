package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Keywords;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/keywords")
public class AdminKeywordsCrudController extends BaseCrudController<Keywords> {

}
