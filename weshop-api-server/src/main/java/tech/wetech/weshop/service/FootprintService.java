package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Footprint;
import tech.wetech.weshop.query.FootprintPageQuery;

/**
 * @author cjbi
 */
public interface FootprintService {

    /**
     *  分页查询用户足迹
     * @param footprintPageQuery
     * @return
     */
    PageInfo<Footprint> queryFootprintPageInfo(FootprintPageQuery footprintPageQuery);


}
