package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.Brand;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */

@FeignClient(value = "weshop-goods", path = "brand")
public interface BrandApi extends Api<Brand> {

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    List<Brand> queryList(Brand entity);

}
