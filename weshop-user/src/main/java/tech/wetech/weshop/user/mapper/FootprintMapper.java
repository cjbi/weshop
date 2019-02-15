package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface FootprintMapper extends MyMapper<Footprint> {

    List<GoodsFootprintBO> selectGoodsFootprintByUserId(Integer userId);

}