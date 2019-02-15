package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

@RequestMapping("/footprint")
@FeignClient(value = "weshop-user")
public interface FootprintApi extends Api<Footprint> {

    @GetMapping("/queryGoodsFootprintTimeLine")
    List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();
}
