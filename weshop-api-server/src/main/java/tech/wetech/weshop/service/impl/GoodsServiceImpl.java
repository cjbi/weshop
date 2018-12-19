package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.mapper.GoodsMapper;
import tech.wetech.weshop.service.GoodsService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

@Service
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoodsByCategoryIdIn(List<Integer> categoryIds) {
        Weekend<Goods> example = Weekend.of(Goods.class);
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        criteria.andIn(Goods::getCategoryId, categoryIds);
        return goodsMapper.selectByExample(example);
    }
}
