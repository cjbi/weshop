package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Brand;
@RestController
@RequestMapping("/wechat/brand")
public class WechatBrandController extends BaseCrudController<Brand> {

}
