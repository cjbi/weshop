package tech.wetech.weshop.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/collect")
public interface CollectService extends IService<Collect> {

    @PostMapping("/addOrDelete")
    CollectAddOrDeleteResultDTO addOrDelete(@RequestBody CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO);

    @GetMapping("/queryGoodsCollectList")
    List<GoodsCollectBO> queryGoodsCollectList();

}
