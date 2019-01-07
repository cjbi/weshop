package tech.wetech.weshop.service;

import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.vo.CategoryIndexVO;
import tech.wetech.weshop.vo.CategoryVO;

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

    CategoryIndexVO index(Integer cateogyId);

    CategoryVO current(Integer id);
}
