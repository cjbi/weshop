package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.GoodsAttribute;

@RequestMapping("/goodsAttribute")
@FeignClient(value = "weshop-goods-api")
public interface GoodsAttributeApi extends Api<GoodsAttribute> {

}
