package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/category")
@FeignClient(value = "weshop-goods-api")
public interface CategoryApi extends Api<Category> {

    /**
     * 根据类目查询商品
     *
     * @param categoryLevel
     * @return
     */
    @GetMapping("/queryCategoryByLevel")
    List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel);

    @GetMapping("/index")
    CategoryIndexDTO index(Integer cateogyId);

    @GetMapping("/current")
    CategoryDTO current(Integer id);
}
