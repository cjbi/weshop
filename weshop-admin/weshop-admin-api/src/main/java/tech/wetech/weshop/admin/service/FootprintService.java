package tech.wetech.weshop.admin.service;

import tech.wetech.weshop.bo.GoodsFootprintBO;
import tech.wetech.weshop.po.Footprint;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface FootprintService extends IService<Footprint> {

    List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();

}
