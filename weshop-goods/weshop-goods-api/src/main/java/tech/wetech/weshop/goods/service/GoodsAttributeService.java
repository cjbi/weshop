package tech.wetech.weshop.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.goods.po.GoodsAttribute;
import tech.wetech.weshop.service.IService;

@RequestMapping("/goodsAttribute")
public interface GoodsAttributeService extends IService<GoodsAttribute> {

}
