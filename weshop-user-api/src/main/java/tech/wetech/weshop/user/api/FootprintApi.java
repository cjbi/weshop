package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.fallback.FootprintApiFallback;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@FeignClient(value = "weshop-user", path = "footprint", fallback = FootprintApiFallback.class)
public interface FootprintApi extends Api<Footprint> {

    @GetMapping("/queryGoodsFootprintTimeLine")
    Result<List<List<GoodsFootprintBO>>> queryGoodsFootprintTimeLine();
}
