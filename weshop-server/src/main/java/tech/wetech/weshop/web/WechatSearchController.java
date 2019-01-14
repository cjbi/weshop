package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.service.SearchService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.SearchIndexVO;
import tech.wetech.weshop.web.base.BaseController;

import java.util.List;

@RestController
@RequestMapping("/wechat/search")
public class WechatSearchController extends BaseController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/helper")
    public Result<List<String>> helper(String keyword) {
        return Result.success(searchService.helper(keyword));
    }

    @PostMapping("/clear-history")
    public Result clearHistory() {
        searchService.clearHistory();
        return Result.success();
    }

    @GetMapping("/index")
    public Result<SearchIndexVO> index() {
        return Result.success(searchService.index());
    }

}
