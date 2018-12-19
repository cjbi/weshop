package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.mapper.CategoryMapper;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.service.CategoryService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * @author cjbi
 */
@Service
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel) {
        Weekend<Category> example = Weekend.of(Category.class);
        WeekendCriteria<Category, Object> criteria = example.weekendCriteria();
        criteria.andEqualTo(Category::getLevel, categoryLevel.name());
        return categoryMapper.selectByExample(example);
    }
}
