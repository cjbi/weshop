package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.service.WechatCollectService;
import tech.wetech.weshop.wechat.utils.JwtHelper;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteParamVO;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteResultVO;

@RestController
@RequestMapping("/wechat/collect")
public class WechatCollectController extends BaseController {

    @Autowired
    private CollectApi collectApi;

    @Autowired
    private WechatCollectService wechatCollectService;

    @PostMapping("/add-or-delete")
    public Result<CollectAddOrDeleteResultVO> addOrDelete(@RequestBody CollectAddOrDeleteParamVO collectAddOrDeleteParamDTO) {
        return Result.success(wechatCollectService.addOrDelete(collectAddOrDeleteParamDTO));
    }

    @GetMapping("/list")
    public Result queryList(Integer typeId) {
        User userInfo = JwtHelper.getUserInfo();
        return collectApi.queryGoodsCollectList(userInfo.getId());
    }

}
