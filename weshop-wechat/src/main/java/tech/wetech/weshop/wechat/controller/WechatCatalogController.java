package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.dto.CategoryDTO;
import tech.wetech.weshop.goods.dto.CategoryIndexDTO;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/catalog")
@Validated
public class WechatCatalogController extends BaseController {

    @Autowired
    private CategoryApi categoryApi;

    @GetMapping("/index")
    public Result<CategoryIndexDTO> index(Integer id) {
        return categoryApi.index(id);
    }

    @GetMapping("/current")
    public Result<CategoryDTO> current(@NotNull @RequestParam("id") Integer id) {
        return categoryApi.current(id);
    }

}
