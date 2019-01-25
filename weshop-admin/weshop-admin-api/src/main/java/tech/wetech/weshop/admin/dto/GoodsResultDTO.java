package tech.wetech.weshop.admin.dto;

import tech.wetech.weshop.po.Goods;

import java.util.List;

public class GoodsResultDTO {

    private List<Goods> goodsList;

    List<CategoryFilterDTO> filterCategory;

    public static final GoodsResultDTO EMPTY_GOODS_RESULT = new GoodsResultDTO();

    public GoodsResultDTO() {
    }

    public GoodsResultDTO(List<Goods> goodsList, List<CategoryFilterDTO> filterCategory) {
        this.goodsList = goodsList;
        this.filterCategory = filterCategory;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public GoodsResultDTO setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
        return this;
    }

    public List<CategoryFilterDTO> getFilterCategory() {
        return filterCategory;
    }

    public GoodsResultDTO setFilterCategory(List<CategoryFilterDTO> filterCategory) {
        this.filterCategory = filterCategory;
        return this;
    }
}
