package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.bo.GoodsFootprintBO;
import tech.wetech.weshop.po.Footprint;
import tech.wetech.weshop.service.FootprintService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wechat/footprint")
public class WechatFootprintController extends BaseController {

    @Autowired
    private FootprintService footprintService;

    @GetMapping("/timeline")
    public Result<Map<String, List<GoodsFootprintBO>>> queryGoodsFootprintTimeLine() {
        return Result.success(footprintService.queryGoodsFootprintTimeLine());
    }

    @DeleteMapping("/{goodsId}")
    public Result deleteGoodsFootprint(@PathVariable Integer goodsId) {
        footprintService.delete(new Footprint().setGoodsId(goodsId).setUserId(Constants.CURRENT_USER_ID));
        return Result.success();
    }

}
