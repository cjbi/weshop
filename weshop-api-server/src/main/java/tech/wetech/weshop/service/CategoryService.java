package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.query.CategoryPageQuery;

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

}
