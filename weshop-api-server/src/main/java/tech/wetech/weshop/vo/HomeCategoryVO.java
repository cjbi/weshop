package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Goods;

import java.util.List;

public class HomeCategoryVO {

    private Integer id;

    private String name;

    private List<Goods> goodsList;

    public HomeCategoryVO() {
    }

    public HomeCategoryVO(Integer id, String name, List<Goods> goodsList) {
        this.id = id;
        this.name = name;
        this.goodsList = goodsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
