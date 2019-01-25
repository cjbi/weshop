package tech.wetech.weshop.wechat.dto;

import tech.wetech.weshop.po.Goods;

import java.math.BigDecimal;

public class GoodsListDTO {

    private Integer id;

    private String name;

    private String listPicUrl;

    private BigDecimal retailPrice;

    public GoodsListDTO(Goods goods) {
        this.id = goods.getId();
        this.name = goods.getName();
        this.listPicUrl = goods.getListPicUrl();
        this.retailPrice = goods.getRetailPrice();
    }

    public Integer getId() {
        return id;
    }

    public GoodsListDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsListDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public GoodsListDTO setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public GoodsListDTO setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }
}
