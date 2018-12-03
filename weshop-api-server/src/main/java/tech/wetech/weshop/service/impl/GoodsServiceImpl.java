package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.GoodsMapper;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.GoodsPageQuery;
import tech.wetech.weshop.service.GoodsService;
import tech.wetech.weshop.vo.CreateGoodsFormVO;
import tech.wetech.weshop.vo.UpdateGoodsFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public PageInfo<Goods> queryGoodsPageInfo(GoodsPageQuery goodsPageQuery) {

        Weekend<Goods> example = Weekend.of(Goods.class);
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        if (goodsPageQuery.getId() != null) {
            criteria.andEqualTo(Goods::getId, goodsPageQuery.getId());
        }
        if (goodsPageQuery.getName() != null) {
            criteria.andEqualTo(Goods::getName, goodsPageQuery.getName());
        }
        return PageHelper.startPage(goodsPageQuery.getPageNum(), goodsPageQuery.getPageSize())
                .doSelectPageInfo(() -> goodsMapper.selectAll());
    }

    @Override
    public void createGoods(CreateGoodsFormVO createGoodsFormVO) {

    }

    @Override
    public void updateGoods(UpdateGoodsFormVO updateGoodsFormVO) {

    }

    @Override
    public void deleteGoods(Integer goodsId) {

    }
}
