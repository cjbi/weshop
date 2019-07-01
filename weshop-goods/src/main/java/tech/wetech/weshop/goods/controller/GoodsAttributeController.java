package tech.wetech.weshop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.api.GoodsAttributeApi;
import tech.wetech.weshop.goods.dto.GoodsAttributeDTO;
import tech.wetech.weshop.goods.po.GoodsAttribute;
import tech.wetech.weshop.goods.service.GoodsAttributeService;

import java.util.List;

@RestController
@RequestMapping("/goodsAttribute")
public class GoodsAttributeController extends BaseApi<GoodsAttribute> implements GoodsAttributeApi {

    private GoodsAttributeService goodsAttributeService;

    @Override
    public Result<List<GoodsAttributeDTO>> queryGoodsDetailAttributeByGoodsId(Integer goodsId) {
        return Result.success(goodsAttributeService.queryGoodsDetailAttributeByGoodsId(goodsId));
    }
}
