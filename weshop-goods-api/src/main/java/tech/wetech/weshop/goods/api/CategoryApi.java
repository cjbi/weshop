package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.dto.CategoryDTO;
import tech.wetech.weshop.goods.dto.CategoryIndexDTO;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.po.Category;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@FeignClient(value = "weshop-goods", path = "category")
public interface CategoryApi extends Api<Category> {

    /**
     * 根据类目查询商品
     *
     * @param categoryLevel
     * @return
     */
    @RequestMapping(value = "/queryCategoryByLevel", method = RequestMethod.GET)
    List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    CategoryIndexDTO index(Integer cateogyId);

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    CategoryDTO current(Integer id);
}
