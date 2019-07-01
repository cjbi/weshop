package tech.wetech.weshop.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.goods.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseApi<Category> implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Result<List<Integer>> queryIdsByParentId(Integer parentId) {
        return Result.success(categoryService.queryIdsByParentId(parentId));
    }

    @Override
    public Result<List<Integer>> queryParentIdsByIdIn(List<Integer> ids) {
        return Result.success(categoryService.queryParentIdsByIdIn(ids));
    }

    @Override
    public Result<List<Category>> queryByIdIn(List<Integer> ids) {
        return Result.success(categoryService.queryByIdIn(ids));
    }
}
