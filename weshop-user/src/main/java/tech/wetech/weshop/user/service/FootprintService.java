package tech.wetech.weshop.user.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.user.dto.GoodsFootprintDTO;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface FootprintService extends IService<Footprint> {

    List<GoodsFootprintDTO> queryGoodsFootprintByUserId(Integer userId);

}
