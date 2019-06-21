package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.dto.CategoryDTO;
import tech.wetech.weshop.goods.dto.CategoryIndexDTO;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.fallback.CategoryApiFallback;
import tech.wetech.weshop.goods.po.Category;

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
    Result<List<Category>> queryCategoryByLevel(@RequestParam("categoryLevel") CategoryLevelEnum categoryLevel);

    @GetMapping("/index")
    Result<CategoryIndexDTO> index(@RequestParam(value = "cateogyId", required = false) Integer cateogyId);

    @GetMapping("/current")
    Result<CategoryDTO> current(@RequestParam("id") Integer id);
}
