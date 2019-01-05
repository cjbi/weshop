package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Goods;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/goods")
public class AdminGoodsCrudController extends BaseCrudController<Goods> {

}
