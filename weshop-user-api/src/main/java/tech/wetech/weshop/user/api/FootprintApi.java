package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

@FeignClient(value = "weshop-user", path = "footprint")
public interface FootprintApi extends Api<Footprint> {

    @RequestMapping(value = "/queryGoodsFootprintTimeLine", method = RequestMethod.GET)
    List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();
}
