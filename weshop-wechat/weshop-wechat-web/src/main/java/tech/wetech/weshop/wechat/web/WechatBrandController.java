package tech.wetech.weshop.wechat.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Brand;
import tech.wetech.weshop.web.BaseCrudController;

@RestController
@RequestMapping("/wechat/brand")
public class WechatBrandController extends BaseCrudController<Brand> {

}
