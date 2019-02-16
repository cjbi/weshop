package tech.wetech.weshop.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.query.WrapperPageQuery;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.enums.RegionTypeEnum;
import tech.wetech.weshop.user.po.Region;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/region")
public class AdminRegionController extends BaseController {

    @Autowired
    private RegionApi regionApi;

    @GetMapping("/list")
    public Result<List<Region>> queryList(Region entity, PageQuery page) {
        return regionApi.queryPageList(new WrapperPageQuery(entity, page))
                .addExtra("regionType", Arrays.stream(RegionTypeEnum.values()).collect(Collectors.toMap(e -> e, RegionTypeEnum::getName)));
    }
}
