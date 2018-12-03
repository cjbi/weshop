package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsPageQuery;
import tech.wetech.weshop.service.GoodsService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CreateGoodsFormVO;
import tech.wetech.weshop.vo.PageInfoVO;
import tech.wetech.weshop.vo.UpdateGoodsFormVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public Result<PageInfoVO<Goods>> queryGoodsPageInfo(GoodsPageQuery goodsPageQuery) {
        PageInfo<Goods> goodsPageInfo = goodsService.queryGoodsPageInfo(goodsPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO(goodsPageInfo);
        return Result.success(pageInfoVO);
    }

    @PostMapping("/create")
    public Result createGoods(CreateGoodsFormVO createGoodsFormVO) {
        goodsService.createGoods(createGoodsFormVO);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateGoods(UpdateGoodsFormVO updateGoodsFormVO) {
        goodsService.updateGoods(updateGoodsFormVO);
        return Result.success();
    }

    @DeleteMapping("/{goodsId}")
    public Result deleteGoods(@PathVariable Integer goodsId) {
        goodsService.deleteGoods(goodsId);
        return Result.success();
    }

}
