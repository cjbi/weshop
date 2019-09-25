package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.po.Region;

import java.util.List;

@RestController
@RequestMapping("/wechat/region")
public class WechatRegionController extends BaseController {

    @Autowired
    private RegionApi regionApi;

    @GetMapping("/list")
    public Result<List<Region>> queryList(Short parentId) {
        return regionApi.queryList(new Region().setParentId(parentId));
    }

}
