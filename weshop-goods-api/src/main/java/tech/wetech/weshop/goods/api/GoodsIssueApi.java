package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.GoodsIssue;

@FeignClient(value = "weshop-goods", path = "goodsIssue")
public interface GoodsIssueApi extends Api<GoodsIssue> {

}
