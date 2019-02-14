package tech.wetech.weshop.user.service;

import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface FootprintService extends IService<Footprint> {

    List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();

}
