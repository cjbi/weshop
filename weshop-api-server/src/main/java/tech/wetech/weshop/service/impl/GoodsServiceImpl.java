package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.mapper.GoodsMapper;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.service.GoodsService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.vo.GoodsSearchVO;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
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

    @Override
    public PageInfo<Goods> queryGoodsSearchPageInfo(GoodsSearchQuery goodsSearchQuery) {
        Weekend<Goods> example = Weekend.of(Goods.class);
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        if (goodsSearchQuery.getPageNum() == null) {
            goodsSearchQuery.setPageNum(Constants.DEFAULT_PAGE_NUM);
        }
        if (goodsSearchQuery.getPageSize() == null) {
            goodsSearchQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        }
        if (goodsSearchQuery.getCategoryId() != null) {
            criteria.andEqualTo(Goods::getCategoryId, goodsSearchQuery.getCategoryId());
        }
        if (goodsSearchQuery.getBrandId() != null) {
            criteria.andEqualTo(Goods::getBrandId, goodsSearchQuery.getBrandId());
        }
        if (goodsSearchQuery.getKeyword() != null) {
            criteria.andLike(Goods::getName, "%" + goodsSearchQuery.getKeyword() + "%");
        }
        if (goodsSearchQuery.getIsNew() != null) {
            criteria.andEqualTo(Goods::getIsNew, goodsSearchQuery.getIsNew());
        }
        if (goodsSearchQuery.getIsHot() != null) {
            criteria.andEqualTo(Goods::getIsHot, goodsSearchQuery.getIsHot());
        }
        if (goodsSearchQuery.getOrder() != null) {
            EntityColumn entityColumn = EntityHelper.getColumns(Goods.class)
                    .stream()
                    .filter(column -> column.getProperty().equals(goodsSearchQuery.getOrder()))
                    .findFirst()
                    .orElse(new EntityColumn());
            String orderBy = "";
            if (entityColumn.getColumn() != null) {
                orderBy += entityColumn.getColumn();
            }
            if (goodsSearchQuery.getSort() != null) {
                orderBy += " " + goodsSearchQuery.getSort();
            }
            example.orderBy(orderBy);
        }

        return PageHelper.startPage(goodsSearchQuery.getPageNum(), goodsSearchQuery.getPageSize())
                .doSelectPageInfo(() -> goodsMapper.selectByExample(example));
    }
}
