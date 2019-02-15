package tech.wetech.weshop.goods.mapper;

import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface GoodsMapper extends MyMapper<Goods> {

    List<Goods> selectByIdIn(List<Integer> ids);
}