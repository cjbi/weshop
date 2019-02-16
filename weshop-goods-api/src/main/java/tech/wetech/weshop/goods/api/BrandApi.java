package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.fallback.BrandApiFallback;
import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.utils.Result;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */

@FeignClient(value = "weshop-goods", path = "brand", fallback = BrandApiFallback.class)
public interface BrandApi extends Api<Brand> {

    @Override
    @PostMapping("/queryList")
    Result<List<Brand>> queryList(Brand entity);

}
