package tech.wetech.weshop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.goods.api.RelatedGoodsApi;
import tech.wetech.weshop.goods.po.RelatedGoods;

@RequestMapping("related-goods")
@RestController
public class RelatedGoodsController extends BaseApi<RelatedGoods> implements RelatedGoodsApi {

}
