package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.GoodsApiFallback;
import tech.wetech.weshop.goods.po.Goods;

/**
 * @author cjbi@outlook.com
 */
@FeignClient(value = "weshop-goods", path = "goods", fallback = GoodsApiFallback.class)
public interface GoodsApi extends Api<Goods> {
}
