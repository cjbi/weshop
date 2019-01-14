package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Footprint;
import tech.wetech.weshop.web.base.BaseCrudController;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/footprint")
public class AdminFootprintController extends BaseCrudController<Footprint> {

}
