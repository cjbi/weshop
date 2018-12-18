package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.domain.Goods;
import tech.wetech.weshop.service.GoodsService;
import tech.wetech.weshop.utils.Result;

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
