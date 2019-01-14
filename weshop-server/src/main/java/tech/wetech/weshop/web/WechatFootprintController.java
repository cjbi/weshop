package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.bo.GoodsFootprintBO;
import tech.wetech.weshop.po.Footprint;
import tech.wetech.weshop.service.FootprintService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.base.BaseController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/footprint")
@Validated
public class WechatFootprintController extends BaseController {

    @Autowired
    private FootprintService footprintService;

    @GetMapping("/list")
    public Result<List<List<GoodsFootprintBO>>> queryGoodsFootprintList() {
        return Result.success(footprintService.queryGoodsFootprintTimeLine());
    }

    @PostMapping("/delete")
    public Result deleteGoodsFootprint(@NotNull Integer goodsId) {
        footprintService.delete(new Footprint().setGoodsId(goodsId).setUserId(Constants.CURRENT_USER_ID));
        return Result.success();
    }

}
