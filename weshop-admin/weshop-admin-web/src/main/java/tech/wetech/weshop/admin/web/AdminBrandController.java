package tech.wetech.weshop.admin.web;

import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Brand;
import tech.wetech.weshop.web.BaseCrudController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/brand")
public class AdminBrandController extends BaseCrudController<Brand> {

}
