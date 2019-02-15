package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.GoodsIssue;

@RequestMapping("/goodsIssue")
@FeignClient(value = "weshop-goods-api")
public interface GoodsIssueApi extends Api<GoodsIssue> {

}
