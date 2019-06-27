package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.RelatedGoodsApiFallback;
import tech.wetech.weshop.goods.po.RelatedGoods;

@FeignClient(value = "weshop-goods", path = "related-goods", fallback = RelatedGoodsApiFallback.class)
public interface RelatedGoodsApi extends Api<RelatedGoods> {
}
