package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.GoodsGalleryApi;
import tech.wetech.weshop.goods.po.GoodsGallery;

@Component
public class GoodsGalleryApiFallback extends ApiFallback<GoodsGallery> implements GoodsGalleryApi {
}
