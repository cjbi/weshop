package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.GoodsGallery;

@FeignClient(value = "weshop-goods", path = "goodsGallery")
public interface GoodsGalleryApi extends Api<GoodsGallery> {

}
