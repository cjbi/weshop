package tech.wetech.weshop.goods.po;

import javax.persistence.*;

@Table(name = "weshop_goods_specification")
public class GoodsSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "specification_id")
    private Integer specificationId;

    private String value;

    @Column(name = "pic_url")
    private String picUrl;

    public Integer getId() {
        return id;
    }

    public GoodsSpecification setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public GoodsSpecification setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public GoodsSpecification setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsSpecification setValue(String value) {
        this.value = value;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public GoodsSpecification setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }
}