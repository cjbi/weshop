package tech.wetech.weshop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsApi;
import tech.wetech.weshop.goods.po.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseApi<Goods> implements GoodsApi {
}
