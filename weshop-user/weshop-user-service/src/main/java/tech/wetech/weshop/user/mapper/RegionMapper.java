package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.user.po.Region;
import tech.wetech.weshop.utils.MyMapper;

public interface RegionMapper extends MyMapper<Region> {

    String selectNameById(Short id);
}