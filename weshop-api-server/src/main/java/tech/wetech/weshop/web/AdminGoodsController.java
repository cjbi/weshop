package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.domain.Goods;
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
public class AdminGoodsController extends BaseController<Goods> {

    @Autowired
    private GoodsService goodsService;

    @DeleteMapping("/{goodsId}")
    public Result deleteGoods(@PathVariable Integer goodsId) {
        goodsService.deleteById(goodsId);
        return Result.success();
    }

}
