package tech.wetech.weshop.web;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.service.CategoryService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CategoryIndexVO;
import tech.wetech.weshop.vo.CategoryVO;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/wechat/category")
public class WechatCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/index")
    public Result<CategoryIndexVO> index(Integer id) {

        List<CategoryVO> categoryList = new LinkedList<>();

        PageHelper.startPage(1, 10);
        categoryService.queryList(new Category() {{
            setParentId(0);
        }}).forEach(c -> {
            CategoryVO categoryVO = new CategoryVO(c);
            List<Category> subCategoryList = categoryService.queryList(new Category() {{
                setParentId(c.getId());
            }});
            categoryVO.setSubCategoryList(subCategoryList);
            categoryList.add(categoryVO);
        });

        CategoryVO currentCategory;
        if (id == null) {
            currentCategory = categoryList.get(0);
        } else {
            currentCategory = new CategoryVO(categoryService.queryById(id));
        }
        return Result.success(new CategoryIndexVO(categoryList, currentCategory));
    }

    @GetMapping("/{id}")
    public Result<CategoryVO> current(@PathVariable Integer id) {
        return Result.success(new CategoryVO(categoryService.queryById(id)));
    }

}
