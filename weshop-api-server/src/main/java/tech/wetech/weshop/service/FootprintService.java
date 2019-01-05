package tech.wetech.weshop.service;

import tech.wetech.weshop.bo.GoodsFootprintBO;
import tech.wetech.weshop.po.Footprint;

import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
public interface FootprintService extends IService<Footprint> {

    Map<String, List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();

}
