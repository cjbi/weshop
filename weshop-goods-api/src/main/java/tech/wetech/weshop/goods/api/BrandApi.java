package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.BrandApiFallback;
import tech.wetech.weshop.goods.po.Brand;

/**
 * @author cjbi@outlook.com
 */

@FeignClient(value = "weshop-goods", path = "brand", fallback = BrandApiFallback.class)
public interface BrandApi extends Api<Brand> {
}
