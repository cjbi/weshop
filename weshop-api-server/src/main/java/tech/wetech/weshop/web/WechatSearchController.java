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
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.SearchIndexVO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wechat/search")
public class WechatSearchController {

    @Autowired
    private KeywordsService keywordsService;

    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping("/helper")
    public Result<List<String>> helper(String keyword) {
        return Result.success(keywordsService.helper(keyword));
    }

    @DeleteMapping("/clear-history")
    public Result clearHistory() {
        searchHistoryService.delete(new SearchHistory().setUserId(Constants.CURRENT_USER_ID));
        return Result.success();
    }

    @GetMapping("/index")
    public Result<SearchIndexVO> index() {
        // 取出输入框默认的关键词
        PageHelper.offsetPage(0, 1);
        Keywords defaultKeyword = keywordsService.queryOne(new Keywords().setDefault(true));
        // 取出热闹关键词
        List<Keywords> hotKeywordList = keywordsService.queryList(
                new Keywords().setHot(true),
                new PageQuery().setPageNum(1).setPageSize(10)
        );

        List<String> historyKeywordList = searchHistoryService.queryList(
                new SearchHistory().setUserId(Constants.CURRENT_USER_ID),
                new PageQuery().setPageNum(1).setPageSize(10)
        ).stream()
                .map(SearchHistory::getKeyword)
                .collect(Collectors.toList());

        SearchIndexVO searchIndexVO = new SearchIndexVO()
                .setDefaultKeyword(defaultKeyword)
                .setHotKeywordList(hotKeywordList)
                .setHistoryKeywordList(historyKeywordList);
        return Result.success(searchIndexVO);
    }


}
