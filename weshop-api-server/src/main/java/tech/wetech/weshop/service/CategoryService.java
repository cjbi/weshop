package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.domain.Category;
import tech.wetech.weshop.query.CategoryPageQuery;
import tech.wetech.weshop.vo.CreateCategoryFormVO;
import tech.wetech.weshop.vo.UpdateCategoryFormVO;

import java.util.List;

/**
 * @author cjbi
 */
public interface CategoryService extends IService<Category> {

    /**
     * 根据类目查询商品
     * @param categoryLevel
     * @return
     */
    List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel);

}
