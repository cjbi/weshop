package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.user.po.Region;

public interface RegionMapper extends MyMapper<Region> {

    String selectNameById(Short id);
}