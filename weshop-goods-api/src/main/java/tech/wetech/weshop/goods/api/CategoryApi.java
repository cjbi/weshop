package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.dto.CategoryDTO;
import tech.wetech.weshop.goods.dto.CategoryIndexDTO;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.fallback.CategoryApiFallback;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.utils.Result;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@FeignClient(value = "weshop-goods", path = "category", fallback = CategoryApiFallback.class)
public interface CategoryApi extends Api<Category> {

    /**
     * 根据类目查询商品
     *
     * @param categoryLevel
     * @return
     */
    @GetMapping("/queryCategoryByLevel")
    Result<List<Category>> queryCategoryByLevel(CategoryLevelEnum categoryLevel);

    @GetMapping("/index")
    Result<CategoryIndexDTO> index(Integer cateogyId);

    @GetMapping("/current")
    Result<CategoryDTO> current(Integer id);
}
