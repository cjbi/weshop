package tech.wetech.weshop.goods.dto;

public class GoodsSpecificationDTO {

    private Integer id;

    private String name;

    private Integer goodsId;

    private Integer specificationId;

    private String value;

    private String picUrl;

    public Integer getId() {
        return id;
    }

    public GoodsSpecificationDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsSpecificationDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public GoodsSpecificationDTO setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public GoodsSpecificationDTO setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsSpecificationDTO setValue(String value) {
        this.value = value;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public GoodsSpecificationDTO setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }
}
