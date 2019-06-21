package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.GoodsAttributeApiFallback;
import tech.wetech.weshop.goods.po.GoodsAttribute;

@FeignClient(value = "weshop-goods", path = "goodsAttribute", fallback = GoodsAttributeApiFallback.class)
public interface GoodsAttributeApi extends Api<GoodsAttribute> {

}
