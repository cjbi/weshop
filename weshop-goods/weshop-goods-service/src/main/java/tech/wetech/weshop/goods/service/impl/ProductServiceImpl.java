package tech.wetech.weshop.goods.service.impl;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.goods.po.Product;
import tech.wetech.weshop.goods.service.ProductService;
import tech.wetech.weshop.service.BaseService;

@RestController
public class ProductServiceImpl extends BaseService<Product> implements ProductService {

}
