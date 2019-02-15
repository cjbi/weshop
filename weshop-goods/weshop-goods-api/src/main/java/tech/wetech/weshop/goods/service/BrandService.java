package tech.wetech.weshop.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.service.IService;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/brand")
public interface BrandService extends IService<Brand> {

}
