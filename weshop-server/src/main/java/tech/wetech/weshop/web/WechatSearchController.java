package tech.wetech.weshop.web;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.po.SearchHistory;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.KeywordsService;
import tech.wetech.weshop.service.SearchHistoryService;
import tech.wetech.weshop.service.SearchService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.SearchIndexVO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wechat/search")
public class WechatSearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/helper")
    public Result<List<String>> helper(String keyword) {
        return Result.success(searchService.helper(keyword));
    }

    @DeleteMapping("/clear-history")
    public Result clearHistory() {
        searchService.clearHistory();
        return Result.success();
    }

    @GetMapping("/index")
    public Result<SearchIndexVO> index() {
        return Result.success(searchService.index());
    }

}
