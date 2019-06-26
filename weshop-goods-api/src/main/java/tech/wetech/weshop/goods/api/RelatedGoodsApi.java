package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.goods.po.RelatedGoods;

@FeignClient(value = "weshop-goods", path = "related-goods", fallback = ApiFallback.class)
public interface RelatedGoodsApi extends Api<RelatedGoods> {
}
