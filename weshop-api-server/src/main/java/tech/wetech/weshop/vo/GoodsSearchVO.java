package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Goods;

import java.math.BigDecimal;

public class GoodsSearchVO {

    private Integer id;

    private String name;

    private String listPicUrl;

    private BigDecimal retailPrice;

    public GoodsSearchVO(Goods goods) {
        this.id = goods.getId();
        this.name = goods.getName();
        this.listPicUrl = goods.getListPicUrl();
        this.retailPrice = goods.getRetailPrice();
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

    public GoodsSearchVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
}
