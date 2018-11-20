package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.FootprintPO;
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
    PageInfo<FootprintPO> queryFootprintPageInfo(FootprintPageQuery footprintPageQuery);


}
