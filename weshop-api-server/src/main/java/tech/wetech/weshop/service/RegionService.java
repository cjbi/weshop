package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Region;
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
    Region queryRegionById(Integer regionId);

    /**
     * 分页查询区域
     * @param regionPageQuery
     * @return
     */
    PageInfo<Region> queryRegionPageInfo(RegionPageQuery regionPageQuery);

}
