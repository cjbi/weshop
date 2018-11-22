package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Brand;
import tech.wetech.weshop.query.BrandPageQuery;
import tech.wetech.weshop.vo.CreateBrandFormVO;
import tech.wetech.weshop.vo.UpdateBrandFormVO;

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

    /**
     * 创建品牌商
     * @param createBrandFormVO
     */
    void createBrand(CreateBrandFormVO createBrandFormVO);

    /**
     * 更新品牌商
     * @param updateBrandFormVO
     */
    void updateBrand(UpdateBrandFormVO updateBrandFormVO);

    void deleteBrand(Integer brandId);

}
