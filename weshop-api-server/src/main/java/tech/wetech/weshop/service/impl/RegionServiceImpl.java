package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.RegionMapper;
import tech.wetech.weshop.po.Region;
import tech.wetech.weshop.service.RegionService;

/**
 * @author cjbi
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public Region queryRegionById(Integer regionId) {
        return regionMapper.selectByPrimaryKey(regionId);
    }
}
