package tech.wetech.weshop.goods.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsIssueApi;
import tech.wetech.weshop.goods.po.GoodsIssue;

@RestController
@RequestMapping("/goodsIssue")
public class GoodsIssueController extends BaseApi<GoodsIssue> implements GoodsIssueApi {

}
