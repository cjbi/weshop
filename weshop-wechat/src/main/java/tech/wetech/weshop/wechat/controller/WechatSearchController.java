package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.wechat.service.WechatSearchService;
import tech.wetech.weshop.wechat.vo.SearchIndexVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/search")
public class WechatSearchController extends BaseController {

    @Autowired
    private WechatSearchService wechatSearchService;

    @GetMapping("/helper")
    public ResultWrapper<List<String>> helper(String keyword) {
        return ResultWrapper.success(wechatSearchService.helper(keyword));
    }

    @PostMapping("/clear-history")
    public ResultWrapper clearHistory() {
        wechatSearchService.clearHistory();
        return ResultWrapper.success();
    }

    @GetMapping("/index")
    public ResultWrapper<SearchIndexVO> index() {
        return ResultWrapper.success(wechatSearchService.index());
    }

}
