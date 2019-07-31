package tech.wetech.weshop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.KeywordsApi;
import tech.wetech.weshop.user.po.Keywords;
import tech.wetech.weshop.user.service.KeywordsService;

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
