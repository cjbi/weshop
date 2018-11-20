package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.RegionPO;
import tech.wetech.weshop.query.RegionPageQuery;

/**
 * @author cjbi
 */
public interface RegionService {

    /**
     * 根据区域id查询区域
     * @param regionId
     * @return
     */
    RegionPO queryRegionById(Integer regionId);

    /**
     * 分页查询区域
     * @param regionPageQuery
     * @return
     */
    PageInfo<RegionPO> queryRegionPageInfo(RegionPageQuery regionPageQuery);

}
