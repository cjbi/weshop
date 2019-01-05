package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Footprint;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/footprint")
public class AdminFootprintCrudController extends BaseCrudController<Footprint> {

}
