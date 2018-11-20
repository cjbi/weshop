package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.query.SearchHistoryPageQuery;
import tech.wetech.weshop.service.SearchHistoryService;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/search-history")
public class AdminSearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping("/list")
    public Result<PageInfoVO> querySearchHistoryPageInfo(SearchHistoryPageQuery searchHistoryPageQuery) {
        PageInfo pageInfo = searchHistoryService.querySearchHistoryPageInfo(searchHistoryPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO(pageInfo);
        return Result.success(pageInfoVO);
    }

}
