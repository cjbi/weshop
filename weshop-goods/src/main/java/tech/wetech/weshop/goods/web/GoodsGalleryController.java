package tech.wetech.weshop.goods.web;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsGalleryApi;
import tech.wetech.weshop.goods.po.GoodsGallery;

@RestController("/goodsGallery")
public class GoodsGalleryController extends BaseApi<GoodsGallery> implements GoodsGalleryApi {
}
