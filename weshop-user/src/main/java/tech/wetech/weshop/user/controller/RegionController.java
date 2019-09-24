package tech.wetech.weshop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.po.Region;
import tech.wetech.weshop.user.service.RegionService;

@RestController
@RequestMapping("region")
public class RegionController extends BaseApi<Region> implements RegionApi {

    @Autowired
    private RegionService regionService;

    @Override
    public ResultWrapper<String> queryNameById(Short id) {
        return ResultWrapper.success(regionService.queryNameById(id));
    }
}
