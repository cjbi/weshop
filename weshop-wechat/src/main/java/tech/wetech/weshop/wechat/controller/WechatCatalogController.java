package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.wechat.service.WechatCatalogService;
import tech.wetech.weshop.wechat.vo.CategoryIndexVO;
import tech.wetech.weshop.wechat.vo.CategoryVO;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/wechat/catalog")
@Validated
public class WechatCatalogController extends BaseController {

    @Autowired
    private WechatCatalogService wechatCatalogService;

    @GetMapping("/index")
    public Result<CategoryIndexVO> index(Integer id) {
        return Result.success(wechatCatalogService.index(id));
    }

    @GetMapping("/current")
    public Result<CategoryVO> current(@NotNull @RequestParam("id") Integer id) {
        return Result.success(wechatCatalogService.current(id));
    }

}
