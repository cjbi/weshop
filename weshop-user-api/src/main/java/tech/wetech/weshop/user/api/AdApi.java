package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.fallback.AdApiFallback;
import tech.wetech.weshop.user.po.Ad;

@FeignClient(value = "weshop-user", path = "ad", fallback = AdApiFallback.class)
public interface AdApi extends Api<Ad> {
}
