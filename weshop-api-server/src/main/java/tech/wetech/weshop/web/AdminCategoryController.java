package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.query.CategoryPageQuery;
import tech.wetech.weshop.service.CategoryService;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/category4")
public class AdminCategoryController {

    @Autowired
    private CategoryService brandService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryPageInfo(CategoryPageQuery brandPageQuery) {
        PageInfo pageInfo = brandService.queryCategoryPageInfo(brandPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO(pageInfo);
        return Result.success(pageInfoVO);
    }

}
