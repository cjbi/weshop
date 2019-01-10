package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.service.CollectService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CollectAddOrDeleteParamVO;
import tech.wetech.weshop.vo.CollectAddOrDeleteResultVO;

@RestController
@RequestMapping("/wechat/collect")
public class WechatCollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping("/add-or-delete")
    public Result<CollectAddOrDeleteResultVO> addOrDelete(@RequestBody CollectAddOrDeleteParamVO collectAddOrDeleteParamVO) {
        return Result.success(collectService.addOrDelete(collectAddOrDeleteParamVO));
    }

    @GetMapping("/list")
    public Result queryList(Integer typeId) {
        return Result.success(collectService.queryGoodsCollectList());
    }

}
