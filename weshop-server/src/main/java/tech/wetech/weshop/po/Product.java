package tech.wetech.weshop.po;

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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return goods_specification_ids
     */
    public String getGoodsSpecificationIds() {
        return goodsSpecificationIds;
    }

    /**
     * @param goodsSpecificationIds
     */
    public void setGoodsSpecificationIds(String goodsSpecificationIds) {
        this.goodsSpecificationIds = goodsSpecificationIds;
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