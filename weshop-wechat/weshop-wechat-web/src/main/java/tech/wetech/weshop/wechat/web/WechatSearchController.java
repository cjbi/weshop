package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;
import tech.wetech.weshop.marketing.service.SearchService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

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
    public Result<SearchIndexDTO> index() {
        return Result.success(searchService.index());
    }

}
