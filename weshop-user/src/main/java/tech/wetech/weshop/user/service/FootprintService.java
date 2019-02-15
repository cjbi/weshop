package tech.wetech.weshop.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface FootprintService extends IService<Footprint> {

    List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();

}
