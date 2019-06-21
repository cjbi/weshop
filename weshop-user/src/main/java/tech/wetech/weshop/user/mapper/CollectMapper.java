package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

public interface CollectMapper extends MyMapper<Collect> {

    List<GoodsCollectBO> selectGoodsCollectByUserId(Integer userId);

}