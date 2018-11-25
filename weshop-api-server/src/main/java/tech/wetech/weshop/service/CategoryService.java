package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.query.CategoryPageQuery;
import tech.wetech.weshop.vo.CreateCategoryFormVO;
import tech.wetech.weshop.vo.UpdateCategoryFormVO;

import java.util.List;

/**
 * @author cjbi
 */
public interface CategoryService {

    /**
     * 分页查询类目
     * @param categoryPageQuery
     * @return
     */
    PageInfo<Category> queryCategoryPageInfo(CategoryPageQuery categoryPageQuery);

    /**
     * 根据类目查询商品
     * @param categoryLevel
     * @return
     */
    List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel);

    /**
     * 创建类目
     * @param createCategoryFormVO
     */
    void createCategory(CreateCategoryFormVO createCategoryFormVO);

    /**
     * 修改类目
     * @param updateCategoryFormVO
     */
    void updateCategory(UpdateCategoryFormVO updateCategoryFormVO);

    /**
     * 删除类目
     * @param id
     */
    void deleteCategory(Integer id);

}
