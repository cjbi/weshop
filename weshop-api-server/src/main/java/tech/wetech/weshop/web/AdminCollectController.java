package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.query.CollectPageQuery;
import tech.wetech.weshop.service.CollectService;
import tech.wetech.weshop.vo.CollectPageVO;
import tech.wetech.weshop.vo.Pagination;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/collect")
public class AdminCollectController {

    @Autowired
    private CollectService collectService;

    @GetMapping("/list")
    public Result<CollectPageVO> queryCollectPageInfo(CollectPageQuery collectPageQuery) {
        PageInfo pageInfo = collectService.queryCollectPageInfo(collectPageQuery);
        Pagination pagination = new Pagination(pageInfo);
        CollectPageVO collectPageVO = new CollectPageVO();
        collectPageVO.setList(pageInfo.getList());
        collectPageVO.setPagination(pagination);
        return Result.success(collectPageVO);
    }

}
