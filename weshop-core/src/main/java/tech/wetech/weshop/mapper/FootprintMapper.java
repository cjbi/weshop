package tech.wetech.weshop.mapper;

import tech.wetech.weshop.bo.GoodsFootprintBO;
import tech.wetech.weshop.po.Footprint;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface FootprintMapper extends MyMapper<Footprint> {

    List<GoodsFootprintBO> selectGoodsFootprintByUserId(Integer userId);

}