package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

@RequestMapping("/collect")
@FeignClient(value = "weshop-user")
public interface CollectApi extends Api<Collect> {

    @PostMapping("/addOrDelete")
    CollectAddOrDeleteResultDTO addOrDelete(@RequestBody CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO);

    @GetMapping("/queryGoodsCollectList")
    List<GoodsCollectBO> queryGoodsCollectList();
}
