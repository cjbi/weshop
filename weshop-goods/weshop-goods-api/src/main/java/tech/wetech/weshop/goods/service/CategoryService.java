package tech.wetech.weshop.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.goods.dto.CategoryDTO;
import tech.wetech.weshop.goods.dto.CategoryIndexDTO;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/category")
public interface CategoryService extends IService<Category> {

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
