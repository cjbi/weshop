package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CategoryMapper;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.query.CategoryPageQuery;
import tech.wetech.weshop.service.CategoryService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<Category> queryCategoryPageInfo(CategoryPageQuery categoryPageQuery) {
        Weekend<Category> example = Weekend.of(Category.class);
        WeekendCriteria<Category, Object> criteria = example.weekendCriteria();
        if(categoryPageQuery.getId() != null) {
            criteria.andEqualTo(Category::getId,categoryPageQuery.getId());
        }
        if(categoryPageQuery.getName() != null) {
            criteria.andEqualTo(Category::getName,categoryPageQuery.getName());
        }
        return PageHelper.startPage(categoryPageQuery.getPageNum(), categoryPageQuery.getPageSize())
                .doSelectPageInfo(() -> categoryMapper.selectByExample(example));
    }
}
