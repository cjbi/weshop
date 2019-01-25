package tech.wetech.weshop.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.admin.service.CategoryService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseCrudController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController extends BaseCrudController<Category> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Result<List<Category>> queryList(Category entity, PageQuery pageQuery) {
        return super.queryList(entity, pageQuery)
                .addExtra("categoryLevel", Arrays.stream(CategoryLevelEnum.values()).collect(Collectors.toMap(c -> c, CategoryLevelEnum::getName)))
                .addExtra("l1", categoryService.queryCategoryByLevel(CategoryLevelEnum.L1));
    }
}
