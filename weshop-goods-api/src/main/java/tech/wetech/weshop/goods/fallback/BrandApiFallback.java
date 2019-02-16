package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.BrandApi;
import tech.wetech.weshop.goods.po.Brand;

@Component
public class BrandApiFallback extends ApiFallback<Brand> implements BrandApi {


}
