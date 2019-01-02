package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.RegionTypeEnum;
import tech.wetech.weshop.po.Region;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.PageInfoVO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/region")
public class AdminRegionController extends BaseController<Region> {

    @Override
    public Result<PageInfoVO<Region>> queryPageInfo(Region entity, PageQuery page) {
        Map<String, Object> extra = new HashMap<String, Object>(16) {{
            put("regionType", Arrays.stream(RegionTypeEnum.values()).collect(Collectors.toMap(e -> e, RegionTypeEnum::getName)));
        }};
        Result<PageInfoVO<Region>> result = super.queryPageInfo(entity, page);
        result.getData().setExtra(extra);
        return result;
    }
}
