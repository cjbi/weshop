package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.GoodsAttribute;

@FeignClient(value = "weshop-goods", path = "goodsAttribute")
public interface GoodsAttributeApi extends Api<GoodsAttribute> {

}
