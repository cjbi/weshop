package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.FootprintApi;
import tech.wetech.weshop.user.dto.GoodsFootprintDTO;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.service.WechatFootprintService;
import tech.wetech.weshop.wechat.utils.JwtHelper;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/footprint")
@Validated
public class WechatFootprintController extends BaseController {

    @Autowired
    private FootprintApi footprintApi;

    @Autowired
    private WechatFootprintService wechatFootprintService;

    @GetMapping("/list")
    public Result<List<List<GoodsFootprintDTO>>> queryGoodsFootprintList() {
        return Result.success(wechatFootprintService.queryGoodsFootprintTimeLine());
    }

    @PostMapping("/delete")
    public Result deleteGoodsFootprint(@NotNull Integer goodsId) {
        User userInfo = JwtHelper.getUserInfo();
        return footprintApi.delete(new Footprint().setGoodsId(goodsId).setUserId(userInfo.getId()));
    }

}
