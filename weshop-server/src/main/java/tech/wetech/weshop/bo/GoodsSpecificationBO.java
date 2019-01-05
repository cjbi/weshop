package tech.wetech.weshop.bo;

public class GoodsSpecificationBO {

    private Integer id;

    private String name;

    private Integer goodsId;

    private Integer specificationId;

    private String value;

    private String picUrl;

    public Integer getId() {
        return id;
    }

    public GoodsSpecificationBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsSpecificationBO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public GoodsSpecificationBO setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public GoodsSpecificationBO setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsSpecificationBO setValue(String value) {
        this.value = value;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public GoodsSpecificationBO setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }
}
