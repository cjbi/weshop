package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.user.dto.GoodsFootprintDTO;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

public interface FootprintMapper extends MyMapper<Footprint> {

    List<GoodsFootprintDTO> selectGoodsFootprintByUserId(Integer userId);

}