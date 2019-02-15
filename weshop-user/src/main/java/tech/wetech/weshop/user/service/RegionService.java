package tech.wetech.weshop.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.po.Region;

/**
 * @author cjbi@outlook.com
 */
public interface RegionService extends IService<Region> {

    String queryNameById(Short id);

}
