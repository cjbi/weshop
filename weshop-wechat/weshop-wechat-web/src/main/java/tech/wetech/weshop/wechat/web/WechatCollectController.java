package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.service.CollectService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

@RestController
@RequestMapping("/wechat/collect")
public class WechatCollectController extends BaseController {

    @Autowired
    private CollectService collectService;

    @PostMapping("/add-or-delete")
    public Result<CollectAddOrDeleteResultDTO> addOrDelete(@RequestBody CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO) {
        return Result.success(collectService.addOrDelete(collectAddOrDeleteParamDTO));
    }

    @GetMapping("/list")
    public Result queryList(Integer typeId) {
        return Result.success(collectService.queryGoodsCollectList());
    }

}
