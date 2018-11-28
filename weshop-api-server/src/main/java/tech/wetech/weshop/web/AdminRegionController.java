package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Region;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.enums.RegionTypeEnum;
import tech.wetech.weshop.query.RegionPageQuery;
import tech.wetech.weshop.service.RegionService;
import tech.wetech.weshop.vo.PageInfoVO;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/region")
public class AdminRegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryRegionPageInfo(RegionPageQuery regionPageQuery) {
        PageInfo<Region> regionPageInfo = regionService.queryRegionPageInfo(regionPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO.Builder(regionPageInfo)
                .addExtra("regionType", Arrays.stream(RegionTypeEnum.values()).collect(Collectors.toMap(e -> e, RegionTypeEnum::getName)))
                .build();
        return Result.success(pageInfoVO);
    }

}
