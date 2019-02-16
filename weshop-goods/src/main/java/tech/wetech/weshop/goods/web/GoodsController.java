package tech.wetech.weshop.goods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.GoodsApi;
import tech.wetech.weshop.goods.dto.GoodsCategoryDTO;
import tech.wetech.weshop.goods.dto.GoodsDetailDTO;
import tech.wetech.weshop.goods.dto.GoodsListDTO;
import tech.wetech.weshop.goods.dto.GoodsResultDTO;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.goods.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseApi<Goods> implements GoodsApi {

    @Autowired
    private GoodsService goodsService;

    @Override
    public List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList) {
        return goodsService.queryListByCategoryIdIn(categoryIdList);
    }

    @Override
    public GoodsResultDTO queryList(GoodsSearchQuery goodsSearchQuery) {
        return goodsService.queryList(goodsSearchQuery);
    }

    @Override
    public GoodsDetailDTO queryGoodsDetail(Integer goodsId) {
        return goodsService.queryGoodsDetail(goodsId);
    }

    @Override
    public List<GoodsListDTO> queryRelatedGoods(Integer goodsId) {
        return goodsService.queryRelatedGoods(goodsId);
    }

    @Override
    public GoodsCategoryDTO queryGoodsCategory(Integer categoryId) {
        return goodsService.queryGoodsCategory(categoryId);
    }
}
