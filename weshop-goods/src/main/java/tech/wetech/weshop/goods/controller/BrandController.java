package tech.wetech.weshop.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.api.BrandApi;
import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.goods.service.BrandService;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController extends BaseApi<Brand> implements BrandApi {

    @Autowired
    private BrandService brandService;

    @Override
    public Result<List<Brand>> queryList(Brand entity) {
        return Result.success(brandService.queryList(entity));
    }


}
