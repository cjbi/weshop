package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.wechat.service.WechatSearchService;
import tech.wetech.weshop.wechat.vo.SearchIndexVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/search")
public class WechatSearchController extends BaseController {

    @Autowired
    private WechatSearchService wechatSearchService;

    @GetMapping("/helper")
    public Result<List<String>> helper(String keyword) {
        return Result.success(wechatSearchService.helper(keyword));
    }

    @PostMapping("/clear-history")
    public Result clearHistory() {
        wechatSearchService.clearHistory();
        return Result.success();
    }

    @GetMapping("/index")
    public Result<SearchIndexVO> index() {
        return Result.success(wechatSearchService.index());
    }

}
