package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.user.dto.GoodsCollectDTO;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

public interface CollectMapper extends MyMapper<Collect> {

    List<GoodsCollectDTO> selectGoodsCollectByUserId(Integer userId);

}