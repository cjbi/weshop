package tech.wetech.weshop.admin.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.mapper.CategoryMapper;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.admin.dto.CategoryIndexDTO;
import tech.wetech.weshop.admin.dto.CategoryDTO;
import tech.wetech.weshop.service.BaseService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cjbi@outlook.com
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
    public CategoryIndexDTO index(Integer categoryId) {
        List<CategoryDTO> categoryList = new LinkedList<>();
        PageHelper.startPage(1, 10);
        categoryMapper.select(new Category().setParentId(0)).forEach(c -> {
            CategoryDTO categoryDTO = new CategoryDTO(c);
            List<Category> subCategoryList = categoryMapper.select(new Category().setParentId(c.getId()));
            categoryDTO.setSubCategoryList(subCategoryList);
            categoryList.add(categoryDTO);
        });

        CategoryDTO currentCategory;
        if (categoryId == null) {
            currentCategory = categoryList.get(0);
        } else {
            currentCategory = new CategoryDTO(categoryMapper.selectByPrimaryKey(categoryId));
        }
        return new CategoryIndexDTO(categoryList, currentCategory);
    }

    @Override
    public CategoryDTO current(Integer id) {
        CategoryDTO categoryDTO = new CategoryDTO(categoryMapper.selectByPrimaryKey(id));
        List<Category> subCategoryList = categoryMapper.select(new Category().setParentId(id));
        categoryDTO.setSubCategoryList(subCategoryList);
        return categoryDTO;
    }
}
