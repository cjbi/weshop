package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.GoodsGalleryApiFallback;
import tech.wetech.weshop.goods.po.GoodsGallery;

@FeignClient(value = "weshop-goods", path = "goodsGallery", fallback = GoodsGalleryApiFallback.class)
public interface GoodsGalleryApi extends Api<GoodsGallery> {

}
