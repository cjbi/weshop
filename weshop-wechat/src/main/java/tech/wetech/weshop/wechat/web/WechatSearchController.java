package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.marketing.api.SearchApi;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

import java.util.List;

@RestController
@RequestMapping("/wechat/search")
public class WechatSearchController extends BaseController {

    @Autowired
    private SearchApi searchApi;

    @GetMapping("/helper")
    public Result<List<String>> helper(String keyword) {
        return searchApi.helper(keyword);
    }

    @PostMapping("/clear-history")
    public Result clearHistory() {
        searchApi.clearHistory();
        return searchApi.clearHistory();
    }

    @GetMapping("/index")
    public Result<SearchIndexDTO> index() {
        return searchApi.index();
    }

}
