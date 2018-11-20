package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.query.FootprintPageQuery;
import tech.wetech.weshop.service.FootprintService;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/footprint")
public class AdminFootprintController {

    @Autowired
    private FootprintService footprintService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryFootprintPageInfo(FootprintPageQuery footprintPageQuery) {
        PageInfo pageInfo = footprintService.queryFootprintPageInfo(footprintPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO(pageInfo);
        return Result.success(pageInfoVO);
    }

}
