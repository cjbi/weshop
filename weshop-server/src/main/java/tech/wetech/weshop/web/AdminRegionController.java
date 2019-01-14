package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.RegionTypeEnum;
import tech.wetech.weshop.po.Region;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.base.BaseCrudController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/region")
public class AdminRegionController extends BaseCrudController<Region> {

    @Override
    public Result<List<Region>> queryList(Region entity, PageQuery page) {
        return super.queryList(entity, page)
                .addExtra("regionType", Arrays.stream(RegionTypeEnum.values()).collect(Collectors.toMap(e -> e, RegionTypeEnum::getName)));
    }
}
