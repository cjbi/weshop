package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.mapper.CategoryMapper;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.query.CategoryPageQuery;
import tech.wetech.weshop.service.CategoryService;
import tech.wetech.weshop.vo.CreateCategoryFormVO;
import tech.wetech.weshop.vo.UpdateCategoryFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

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

    @Override
    public List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel) {
        Weekend<Category> example = Weekend.of(Category.class);
        WeekendCriteria<Category, Object> criteria = example.weekendCriteria();
        criteria.andEqualTo(Category::getLevel,categoryLevel.name());
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void createCategory(CreateCategoryFormVO createCategoryFormVO) {
        Category category = new Category(createCategoryFormVO);
        categoryMapper.insertSelective(category);
    }

    @Override
    public void updateCategory(UpdateCategoryFormVO updateCategoryFormVO) {
        Category category = new Category(updateCategoryFormVO);
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
