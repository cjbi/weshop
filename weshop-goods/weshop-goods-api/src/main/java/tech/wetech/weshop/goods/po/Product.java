package tech.wetech.weshop.goods.po;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "weshop_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_specification_ids")
    private String goodsSpecificationIds;

    @Column(name = "goods_sn")
    private String goodsSn;

    @Column(name = "goods_number")
    private Integer goodsNumber;

    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Product setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsSpecificationIds() {
        return goodsSpecificationIds;
    }

    public Product setGoodsSpecificationIds(String goodsSpecificationIds) {
        this.goodsSpecificationIds = goodsSpecificationIds;
        return this;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public Product setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
        return this;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public Product setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public Product setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }
}