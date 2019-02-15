package tech.wetech.weshop.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.BrandApi;
import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.goods.service.BrandService;

import java.util.List;

@RestController("/brand")
public class BrandController extends BaseApi<Brand> implements BrandApi {

    @Autowired
    private BrandService brandService;

    @Override
    public List<Brand> queryList(Brand entity) {
        return brandService.queryList(entity);
    }


}
