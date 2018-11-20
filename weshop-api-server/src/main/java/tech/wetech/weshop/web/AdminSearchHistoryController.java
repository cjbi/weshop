package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.query.SearchHistoryPageQuery;
import tech.wetech.weshop.service.SearchHistoryService;
import tech.wetech.weshop.vo.Pagination;
import tech.wetech.weshop.vo.SearchHistoryPageVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/search-history")
public class AdminSearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping("/list")
    public Result<SearchHistoryPageVO> querySearchHistoryPageInfo(SearchHistoryPageQuery searchHistoryPageQuery) {
        PageInfo pageInfo = searchHistoryService.querySearchHistoryPageInfo(searchHistoryPageQuery);
        Pagination pagination = new Pagination(pageInfo);
        SearchHistoryPageVO searchHistoryPageVO = new SearchHistoryPageVO();
        searchHistoryPageVO.setList(pageInfo.getList());
        searchHistoryPageVO.setPagination(pagination);
        return Result.success(searchHistoryPageVO);
    }

}
