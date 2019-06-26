package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.goods.po.Goods;

import java.math.BigDecimal;

public class GoodsListVO {

    private Integer id;

    private String name;

    private String listPicUrl;

    private BigDecimal retailPrice;

    public GoodsListVO() {
    }

    public GoodsListVO(Goods goods) {
        this.id = goods.getId();
        this.name = goods.getName();
        this.listPicUrl = goods.getListPicUrl();
        this.retailPrice = goods.getRetailPrice();
    }

    public Integer getId() {
        return id;
    }

    public GoodsListVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsListVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public GoodsListVO setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public GoodsListVO setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }
}
