package tech.wetech.weshop.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.po.Region;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/region")
public interface RegionService extends IService<Region> {

    @GetMapping("/queryNameById")
    String queryNameById(Short id);

}
