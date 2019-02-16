package tech.wetech.weshop.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.FootprintApi;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.service.FootprintService;

import java.util.List;

@RestController
@RequestMapping("footprint")
public class FootprintController extends BaseApi<Footprint> implements FootprintApi {

    @Autowired
    private FootprintService footprintService;

    @Override
    public List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine() {
        return footprintService.queryGoodsFootprintTimeLine();
    }
}
