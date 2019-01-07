package tech.wetech.weshop.service;

import tech.wetech.weshop.bo.GoodsFootprintBO;
import tech.wetech.weshop.po.Footprint;

import java.util.List;

/**
 * @author cjbi
 */
public interface FootprintService extends IService<Footprint> {

    List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();

}
