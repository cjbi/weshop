package tech.wetech.weshop.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.goods.po.GoodsGallery;
import tech.wetech.weshop.service.IService;

@RequestMapping("/goodsGallery")
public interface GoodsGalleryService extends IService<GoodsGallery> {

}
