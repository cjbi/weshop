package tech.wetech.weshop.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.dto.CategoryDTO;
import tech.wetech.weshop.goods.dto.CategoryIndexDTO;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.goods.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseApi<Category> implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel) {
        return categoryService.queryCategoryByLevel(categoryLevel);
    }

    @Override
    public CategoryIndexDTO index(Integer cateogyId) {
        return categoryService.index(cateogyId);
    }

    @Override
    public CategoryDTO current(Integer id) {
        return categoryService.current(id);
    }
}
