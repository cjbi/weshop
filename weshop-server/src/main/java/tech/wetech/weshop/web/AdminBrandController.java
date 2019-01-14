package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Brand;
import tech.wetech.weshop.web.base.BaseCrudController;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/brand")
public class AdminBrandController extends BaseCrudController<Brand> {

}
