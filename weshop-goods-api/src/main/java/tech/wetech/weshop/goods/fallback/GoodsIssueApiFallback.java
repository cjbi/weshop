package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.GoodsIssueApi;
import tech.wetech.weshop.goods.po.GoodsIssue;

@Component
public class GoodsIssueApiFallback extends ApiFallback<GoodsIssue> implements GoodsIssueApi {
}
