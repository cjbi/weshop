package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.goods.po.Goods;

import java.util.List;

public class GoodsResultVO {

    private List<Goods> goodsList;

    List<CategoryFilterVO> filterCategory;

    public static final GoodsResultVO EMPTY_GOODS_RESULT = new GoodsResultVO();

    public GoodsResultVO() {
    }

    public GoodsResultVO(List<Goods> goodsList, List<CategoryFilterVO> filterCategory) {
        this.goodsList = goodsList;
        this.filterCategory = filterCategory;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public GoodsResultVO setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
        return this;
    }

    public List<CategoryFilterVO> getFilterCategory() {
        return filterCategory;
    }

    public GoodsResultVO setFilterCategory(List<CategoryFilterVO> filterCategory) {
        this.filterCategory = filterCategory;
        return this;
    }
}
