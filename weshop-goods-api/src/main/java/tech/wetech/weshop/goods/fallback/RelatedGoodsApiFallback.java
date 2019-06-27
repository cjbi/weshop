package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.RelatedGoodsApi;
import tech.wetech.weshop.goods.po.RelatedGoods;

@Component
public class RelatedGoodsApiFallback extends ApiFallback<RelatedGoods> implements RelatedGoodsApi {
}
