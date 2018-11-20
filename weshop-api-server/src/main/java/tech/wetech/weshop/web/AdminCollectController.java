package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.query.CollectPageQuery;
import tech.wetech.weshop.service.CollectService;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/collect")
public class AdminCollectController {

    @Autowired
    private CollectService collectService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryCollectPageInfo(CollectPageQuery collectPageQuery) {
        PageInfo pageInfo = collectService.queryCollectPageInfo(collectPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO(pageInfo);
        return Result.success(pageInfoVO);
    }

}
