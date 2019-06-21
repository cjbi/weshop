package tech.wetech.weshop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsGalleryApi;
import tech.wetech.weshop.goods.po.GoodsGallery;

@RestController
@RequestMapping("/goodsGallery")
public class GoodsGalleryController extends BaseApi<GoodsGallery> implements GoodsGalleryApi {
}
