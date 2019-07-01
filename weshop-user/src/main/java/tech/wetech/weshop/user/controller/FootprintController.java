package tech.wetech.weshop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.FootprintApi;
import tech.wetech.weshop.user.dto.GoodsFootprintDTO;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.service.FootprintService;

import java.util.List;

@RestController
@RequestMapping("footprint")
public class FootprintController extends BaseApi<Footprint> implements FootprintApi {

    @Autowired
    private FootprintService footprintService;

    @Override
    public Result<List<GoodsFootprintDTO>> queryGoodsFootprintByUserId(Integer userId) {
        return Result.success(footprintService.queryGoodsFootprintByUserId(userId));
    }
}
