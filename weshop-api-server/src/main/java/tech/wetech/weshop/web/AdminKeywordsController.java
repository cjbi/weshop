package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.query.KeywordsPageQuery;
import tech.wetech.weshop.service.KeywordsService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CreateKeywordsFormVO;
import tech.wetech.weshop.vo.PageInfoVO;
import tech.wetech.weshop.vo.UpdateKeywordsFormVO;

import java.util.Arrays;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/keywords")
public class AdminKeywordsController {

    @Autowired
    private KeywordsService keywordsService;

    @GetMapping("/list")
    public Result queryKeywordsPageInfo(KeywordsPageQuery keywordsPageQuery) {
        PageInfo<Keywords> keywordsPageInfo = keywordsService.queryKeywordsPageInfo(keywordsPageQuery);
        return Result.success(new PageInfoVO(keywordsPageInfo));
    }

    @PostMapping("/create")
    public Result createKeywords(CreateKeywordsFormVO createKeywordsFormVO) {
        keywordsService.createKeywords(createKeywordsFormVO);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateKeywords(UpdateKeywordsFormVO updateKeywordsFormVO) {
        keywordsService.updateKeywords(updateKeywordsFormVO);
        return Result.success();
    }

    public Result deleteKeywords(Integer[] keywordIds) {
        Arrays.stream(keywordIds).forEach(keywordId -> keywordsService.deleteKeyword(keywordId));
        return Result.success();
    }

}
