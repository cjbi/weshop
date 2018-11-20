package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.RegionMapper;
import tech.wetech.weshop.po.RegionPO;
import tech.wetech.weshop.query.RegionPageQuery;
import tech.wetech.weshop.service.RegionService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public RegionPO queryRegionById(Integer regionId) {
        return regionMapper.selectByPrimaryKey(regionId);
    }

    @Override
    public PageInfo<RegionPO> queryRegionPageInfo(RegionPageQuery regionPageQuery) {
        Weekend<RegionPO> example = Weekend.of(RegionPO.class);
        WeekendCriteria<RegionPO, Object> criteria = example.weekendCriteria();
        if(regionPageQuery.getId() != null) {
            criteria.andEqualTo(RegionPO::getId,regionPageQuery.getId());
        }
        if(regionPageQuery.getName() != null) {
            criteria.andEqualTo(RegionPO::getName,regionPageQuery.getName());
        }
        return PageHelper.startPage(regionPageQuery.getPageNum(), regionPageQuery.getPageSize())
                .doSelectPageInfo(() -> regionMapper.selectByExample(example));
    }
}
