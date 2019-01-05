package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Brand;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/brand")
public class AdminBrandCrudController extends BaseCrudController<Brand> {

}
