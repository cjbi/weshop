package tech.wetech.weshop.marketing.dto;

import tech.wetech.weshop.goods.po.Goods;

import java.io.Serializable;
import java.util.List;

public class HomeCategoryDTO implements Serializable {

    private Integer id;

    private String name;

    private List<Goods> goodsList;

    public HomeCategoryDTO() {
    }

    public HomeCategoryDTO(Integer id, String name, List<Goods> goodsList) {
        this.id = id;
        this.name = name;
        this.goodsList = goodsList;
    }

    public Integer getId() {
        return id;
    }

    public HomeCategoryDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HomeCategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public HomeCategoryDTO setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
        return this;
    }
}
