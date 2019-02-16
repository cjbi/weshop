package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.fallback.CollectApiFallback;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@FeignClient(value = "weshop-user", path = "collect", fallback = CollectApiFallback.class)
public interface CollectApi extends Api<Collect> {

    @PostMapping("/addOrDelete")
    Result<CollectAddOrDeleteResultDTO> addOrDelete(@RequestBody CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO);

    @GetMapping("/queryGoodsCollectList")
    Result<List<GoodsCollectBO>> queryGoodsCollectList();
}
