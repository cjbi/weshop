package tech.wetech.weshop.mapper;

import tech.wetech.weshop.bo.GoodsCollectBO;
import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface CollectMapper extends MyMapper<Collect> {

    List<GoodsCollectBO> selectGoodsCollectByUserId(Integer userId);

}