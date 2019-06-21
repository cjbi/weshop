package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.GoodsIssueApiFallback;
import tech.wetech.weshop.goods.po.GoodsIssue;

@FeignClient(value = "weshop-goods", path = "goodsIssue", fallback = GoodsIssueApiFallback.class)
public interface GoodsIssueApi extends Api<GoodsIssue> {

}
