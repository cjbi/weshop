package tech.wetech.weshop.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.KeywordsApi;
import tech.wetech.weshop.marketing.po.Keywords;
import tech.wetech.weshop.marketing.service.KeywordsService;

import java.util.List;

@RestController
@RequestMapping("/keywords")
public class KeywordsController extends BaseApi<Keywords> implements KeywordsApi {

    @Autowired
    private KeywordsService keywordsService;

    @Override
    public Result<List<String>> queryByKeyword(String keyword) {
        return Result.success(keywordsService.queryByKeyword(keyword));
    }
}
