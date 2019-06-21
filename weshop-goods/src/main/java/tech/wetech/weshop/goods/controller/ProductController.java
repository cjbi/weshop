package tech.wetech.weshop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.goods.api.ProductApi;
import tech.wetech.weshop.goods.po.Product;

@RequestMapping("/product")
@RestController
public class ProductController extends BaseApi<Product> implements ProductApi {
}
