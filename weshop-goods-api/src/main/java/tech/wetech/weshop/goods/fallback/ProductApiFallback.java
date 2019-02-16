package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.ProductApi;
import tech.wetech.weshop.goods.po.Product;

@Component
public class ProductApiFallback extends ApiFallback<Product> implements ProductApi {
}
