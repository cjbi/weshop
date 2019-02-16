package tech.wetech.weshop.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.po.Region;
import tech.wetech.weshop.user.service.RegionService;
import tech.wetech.weshop.utils.Result;

@RestController
@RequestMapping("region")
public class RegionController extends BaseApi<Region> implements RegionApi {

    @Autowired
    private RegionService regionService;

    @Override
    public Result<String> queryNameById(Short id) {
        return Result.success(regionService.queryNameById(id));
    }
}
