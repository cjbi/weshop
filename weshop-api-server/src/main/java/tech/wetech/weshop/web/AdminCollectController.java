package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Collect;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/collect")
public class AdminCollectController extends BaseController<Collect> {

}
