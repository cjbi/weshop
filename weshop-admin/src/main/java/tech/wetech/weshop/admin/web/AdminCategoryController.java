package tech.wetech.weshop.admin.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.query.PageQueryWrapper;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController extends BaseController {

    @Autowired
    private CategoryApi categoryApi;

    @GetMapping("/list")
    public Result<List<Category>> queryList(Category entity, PageQuery pageQuery) {
        return categoryApi.queryPageList(new PageQueryWrapper<>(pageQuery, entity))
                .addExtra("categoryLevel", Arrays.stream(CategoryLevelEnum.values()).collect(Collectors.toMap(c -> c, CategoryLevelEnum::getName)))
                .addExtra("l1", categoryApi.queryCategoryByLevel(CategoryLevelEnum.L1).getData());
    }
}
