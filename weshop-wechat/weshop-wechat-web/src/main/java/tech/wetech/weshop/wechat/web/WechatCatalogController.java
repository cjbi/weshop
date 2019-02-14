package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.goods.dto.CategoryDTO;
import tech.wetech.weshop.goods.dto.CategoryIndexDTO;
import tech.wetech.weshop.goods.service.CategoryService;
import tech.wetech.weshop.utils.Result;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/catalog")
@Validated
public class WechatCatalogController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/index")
    public Result<CategoryIndexDTO> index(Integer id) {
        return Result.success(categoryService.index(id));
    }

    @GetMapping("/current")
    public Result<CategoryDTO> current(@NotNull @RequestParam("id") Integer id) {
        return Result.success(categoryService.current(id));
    }

}
