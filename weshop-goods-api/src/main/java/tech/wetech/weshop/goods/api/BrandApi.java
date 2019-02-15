package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.Brand;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/brand")
@FeignClient(value = "weshop-goods-api")
public interface BrandApi extends Api<Brand> {

    @GetMapping("/queryList")
    List<Brand> queryList(Brand entity);

}
