package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.query.CategoryPageQuery;
import tech.wetech.weshop.service.CategoryService;
import tech.wetech.weshop.vo.CreateCategoryFormVO;
import tech.wetech.weshop.vo.PageInfoVO;
import tech.wetech.weshop.vo.UpdateCategoryFormVO;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService brandService;

    @GetMapping("/list")
    public Result<PageInfoVO<Category>> queryCategoryPageInfo(CategoryPageQuery brandPageQuery) {
        PageInfo pageInfo = brandService.queryCategoryPageInfo(brandPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO.Builder(pageInfo)
                .addExtra("categoryLevel", Arrays.stream(CategoryLevelEnum.values()).collect(Collectors.toMap(c->c,CategoryLevelEnum::getName)))
                .build();
        return Result.success(pageInfoVO);
    }

    @PostMapping("/create")
    public Result createCategory(@Valid @RequestBody CreateCategoryFormVO createCategoryFormVO) {
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateCategory(@Valid @RequestBody UpdateCategoryFormVO updateCategoryFormVO) {
        return Result.success();
    }

    public Result deleteCategory(@Valid @RequestBody Integer[] categoryId) {
        return Result.success();
    }
}
