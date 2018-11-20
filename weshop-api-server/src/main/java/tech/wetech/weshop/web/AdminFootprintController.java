package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.query.FootprintPageQuery;
import tech.wetech.weshop.service.FootprintService;
import tech.wetech.weshop.vo.FootprintPageVO;
import tech.wetech.weshop.vo.Pagination;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/footprint")
public class AdminFootprintController {

    @Autowired
    private FootprintService footprintService;

    @GetMapping("/list")
    public Result<FootprintPageVO> queryFootprintPageInfo(FootprintPageQuery footprintPageQuery) {
        PageInfo pageInfo = footprintService.queryFootprintPageInfo(footprintPageQuery);
        Pagination pagination = new Pagination(pageInfo);
        FootprintPageVO footprintPageVO = new FootprintPageVO();
        footprintPageVO.setList(pageInfo.getList());
        footprintPageVO.setPagination(pagination);
        return Result.success(footprintPageVO);
    }

}
