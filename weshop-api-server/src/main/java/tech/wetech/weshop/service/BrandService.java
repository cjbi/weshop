package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Brand;
import tech.wetech.weshop.query.BrandPageQuery;

/**
 * @author cjbi
 */
public interface BrandService {

    /**
     * 分页查询品牌商
     * @param brandPageQuery
     * @return
     */
    PageInfo<Brand> queryBrandPageInfo(BrandPageQuery brandPageQuery);

}
