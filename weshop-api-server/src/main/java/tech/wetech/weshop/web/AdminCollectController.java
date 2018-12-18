package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.domain.Collect;
import tech.wetech.weshop.service.impl.BaseService;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/collect")
public class AdminCollectController extends BaseService<Collect> {

}
