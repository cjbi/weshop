package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.GoodsIssue;
import tech.wetech.weshop.query.GoodsIssuePageQuery;
import tech.wetech.weshop.service.GoodsIssueService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CreateGoodsIssueFormVO;
import tech.wetech.weshop.vo.PageInfoVO;
import tech.wetech.weshop.vo.UpdateGoodsIssueFormVO;

import java.util.Arrays;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/goods-issue")
public class AdminGoodsIssueController {

    @Autowired
    private GoodsIssueService goodsIssueService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryGoodsIssuePageInfo(GoodsIssuePageQuery goodsIssuePageQuery) {
        PageInfo<GoodsIssue> goodsIssuePageInfo = goodsIssueService.queryGoodsIssuePageInfo(goodsIssuePageQuery);
        return Result.success(new PageInfoVO(goodsIssuePageInfo));
    }

    @PostMapping("/create")
    public Result createGoodsIssue(@RequestBody CreateGoodsIssueFormVO createGoodsIssueFormVO) {
        goodsIssueService.createGoodsIssue(createGoodsIssueFormVO);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateGoodsIssue(@RequestBody UpdateGoodsIssueFormVO updateGoodsIssueFormVO) {
        goodsIssueService.updateGoodsIssue(updateGoodsIssueFormVO);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result deleteGoodsIssue(@RequestBody Integer[] goodsIssueIds) {
        Arrays.stream(goodsIssueIds).forEach(goodsIssueId -> goodsIssueService.deleteGoodsIssue(goodsIssueId));
        return Result.success();
    }

}
