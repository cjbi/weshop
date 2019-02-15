package tech.wetech.weshop.goods.web;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsAttributeApi;
import tech.wetech.weshop.goods.po.GoodsAttribute;

@RestController("/goodsAttribute")
public class GoodsAttributeController extends BaseApi<GoodsAttribute> implements GoodsAttributeApi {
}
