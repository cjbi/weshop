package tech.wetech.weshop.user.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.user.po.Region;

/**
 * @author cjbi@outlook.com
 */
public interface RegionService extends IService<Region> {

    String queryNameById(Short id);

}
