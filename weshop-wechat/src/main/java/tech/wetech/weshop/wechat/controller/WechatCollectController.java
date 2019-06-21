package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;

@RestController
@RequestMapping("/wechat/collect")
public class WechatCollectController extends BaseController {

    @Autowired
    private CollectApi collectApi;

    @PostMapping("/add-or-delete")
    public Result<CollectAddOrDeleteResultDTO> addOrDelete(@RequestBody CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO) {
        return collectApi.addOrDelete(collectAddOrDeleteParamDTO);
    }

    @GetMapping("/list")
    public Result queryList(Integer typeId) {
        return collectApi.queryGoodsCollectList();
    }

}
