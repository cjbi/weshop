package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.mapper.CategoryMapper;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.service.CategoryService;
import tech.wetech.weshop.vo.CategoryIndexVO;
import tech.wetech.weshop.vo.CategoryVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.LinkedList;
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

    @Override
    public CategoryIndexVO index(Integer categoryId) {
        List<CategoryVO> categoryList = new LinkedList<>();
        PageHelper.startPage(1, 10);
        categoryMapper.select(new Category().setParentId(0)).forEach(c -> {
            CategoryVO categoryVO = new CategoryVO(c);
            List<Category> subCategoryList = categoryMapper.select(new Category().setParentId(c.getId()));
            categoryVO.setSubCategoryList(subCategoryList);
            categoryList.add(categoryVO);
        });

        CategoryVO currentCategory;
        currentCategory = new CategoryVO(categoryMapper.selectByPrimaryKey(categoryId));
        return new CategoryIndexVO(categoryList, currentCategory);
    }

    @Override
    public CategoryVO current(Integer id) {
        CategoryVO categoryVO = new CategoryVO(categoryMapper.selectByPrimaryKey(id));
        List<Category> subCategoryList = categoryMapper.select(new Category().setParentId(id));
        categoryVO.setSubCategoryList(subCategoryList);
        return categoryVO;
    }
}
