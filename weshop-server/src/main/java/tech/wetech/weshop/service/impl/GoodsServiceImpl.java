package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CategoryMapper;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.mapper.GoodsMapper;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.service.CategoryService;
import tech.wetech.weshop.service.GoodsService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Reflections;
import tech.wetech.weshop.vo.CategoryFilterVO;
import tech.wetech.weshop.vo.GoodsResultVO;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Goods> queryGoodsByIdIn(List<Integer> ids) {
        Weekend<Goods> example = Weekend.of(Goods.class);
        example.selectProperties(Reflections.fnToFieldName(
                Goods::getId,
                Goods::getName,
                Goods::getListPicUrl,
                Goods::getRetailPrice));
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        criteria.andIn(Goods::getCategoryId, ids);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public List<Goods> queryGoodsByCategoryIdIn(List<Integer> categoryIds) {
        Weekend<Goods> example = Weekend.of(Goods.class);
        example.selectProperties(Reflections.fnToFieldName(
                Goods::getId,
                Goods::getName,
                Goods::getListPicUrl,
                Goods::getRetailPrice));
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        criteria.andIn(Goods::getCategoryId, categoryIds);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public List<Goods> queryGoodsByCategoryId(Integer categoryId) {
        Weekend<Goods> example = Weekend.of(Goods.class);
        example.selectProperties(Reflections.fnToFieldName(
                Goods::getId,
                Goods::getName,
                Goods::getListPicUrl,
                Goods::getRetailPrice));
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        criteria.andEqualTo(Goods::getCategoryId, categoryId);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public GoodsResultVO queryList(GoodsSearchQuery goodsSearchQuery) {
        Weekend<Goods> example = Weekend.of(Goods.class);
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        //没传分类id就查全部
        if (goodsSearchQuery.getCategoryId() == null) {
            goodsSearchQuery.setCategoryId(0);
        }
        if (goodsSearchQuery.getBrandId() != null) {
            criteria.andEqualTo(Goods::getBrandId, goodsSearchQuery.getBrandId());
        }
        if (goodsSearchQuery.getKeyword() != null) {
            criteria.andLike(Goods::getName, "%" + goodsSearchQuery.getKeyword() + "%");
        }
        if (goodsSearchQuery.getNew() != null) {
            criteria.andEqualTo(Goods::getNew, goodsSearchQuery.getNew());
        }
        if (goodsSearchQuery.getHot() != null) {
            criteria.andEqualTo(Goods::getHot, goodsSearchQuery.getHot());
        }
        example.selectProperties(Reflections.fnToFieldName(
                Goods::getCategoryId));
        List<Integer> categoryIds = goodsMapper.selectByExample(example).stream()
                .map(Goods::getCategoryId)
                .collect(Collectors.toList());

        //查询二级分类的parentIds
        List<Integer> parentIds = categoryMapper.selectParentIdsByIdIn(categoryIds);
        //一级分类
        List<CategoryFilterVO> categoryFilter = new LinkedList<CategoryFilterVO>() {{
            add(new CategoryFilterVO(0, "全部", false));
            addAll(categoryMapper.selectByIdIn(parentIds).stream()
                    .map(CategoryFilterVO::new)
                    .collect(Collectors.toList()));
        }};

        categoryFilter.forEach(categoryFilterVO -> categoryFilterVO.setChecked(categoryFilterVO.getId().equals(goodsSearchQuery.getCategoryId())));

        if (goodsSearchQuery.getCategoryId() != null && goodsSearchQuery.getCategoryId() > 0) {
            //根据一级分类ID查询二级分类ID
            List<Integer> idList = new LinkedList<>();
            idList.add(goodsSearchQuery.getCategoryId());
            idList.addAll(Optional.ofNullable(categoryMapper.selectIdsByParentId(goodsSearchQuery.getCategoryId())).orElse(Collections.EMPTY_LIST));
            criteria.andIn(Goods::getCategoryId, idList);
        }
        if (goodsSearchQuery.getOrderBy() != null) {
            example.setOrderByClause(goodsSearchQuery.getOrderBy());
        } else {
            //默认按照添加时间排序
            example.setOrderByClause("id desc");
        }
        example.selectProperties(Reflections.fnToFieldName(
                Goods::getId,
                Goods::getName,
                Goods::getListPicUrl,
                Goods::getRetailPrice));
        List<Goods> goodsList = PageHelper.startPage(goodsSearchQuery)
                .doSelectPage(() -> goodsMapper.selectByExample(example));

        return new GoodsResultVO(goodsList, categoryFilter);
    }
}
