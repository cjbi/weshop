package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.GoodsApi;
import tech.wetech.weshop.goods.dto.GoodsCategoryDTO;
import tech.wetech.weshop.goods.dto.GoodsDetailDTO;
import tech.wetech.weshop.goods.dto.GoodsListDTO;
import tech.wetech.weshop.goods.dto.GoodsResultDTO;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@Component
public class GoodsApiFallback extends ApiFallback<Goods> implements GoodsApi {
    @Override
    public Result<List<Goods>> queryListByCategoryIdIn(List<Integer> categoryIdList) {
        return null;
    }

    @Override
    public Result<GoodsResultDTO> queryList(GoodsSearchQuery goodsSearchQuery) {
        return null;
    }

    @Override
    public Result<GoodsDetailDTO> queryGoodsDetail(Integer goodsId) {
        return null;
    }

    @Override
    public Result<List<GoodsListDTO>> queryRelatedGoods(Integer goodsId) {
        return null;
    }

    @Override
    public Result<GoodsCategoryDTO> queryGoodsCategory(Integer categoryId) {
        return null;
    }
}
