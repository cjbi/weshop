package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.dto.GoodsCollectDTO;
import tech.wetech.weshop.user.fallback.CollectApiFallback;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

@FeignClient(value = "weshop-user", path = "collect", fallback = CollectApiFallback.class)
public interface CollectApi extends Api<Collect> {

    @GetMapping("/queryGoodsCollectList")
    ResultWrapper<List<GoodsCollectDTO>> queryGoodsCollectList(Integer userId);
}
