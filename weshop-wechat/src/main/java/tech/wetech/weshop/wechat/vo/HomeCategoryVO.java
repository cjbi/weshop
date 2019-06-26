package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.goods.po.Goods;

import java.io.Serializable;
import java.util.List;

public class HomeCategoryVO implements Serializable {

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

    public HomeCategoryVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HomeCategoryVO setName(String name) {
        this.name = name;
        return this;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public HomeCategoryVO setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
        return this;
    }
}
