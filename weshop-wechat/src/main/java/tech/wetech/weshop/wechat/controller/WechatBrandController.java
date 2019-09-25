package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.api.BrandApi;
import tech.wetech.weshop.goods.po.Brand;

@RestController
@RequestMapping("/wechat/brand")
public class WechatBrandController extends BaseController {

    @Autowired
    private BrandApi brandApi;

    @GetMapping
    public Result<Brand> query(Integer id) {
        return brandApi.queryById(id);
    }

}
