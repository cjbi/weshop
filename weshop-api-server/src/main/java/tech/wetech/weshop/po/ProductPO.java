package tech.wetech.weshop.po;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "weshop_product")
public class ProductPO {
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

    /**
     * @return goods_sn
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * @param goodsSn
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    /**
     * @return goods_number
     */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * @param goodsNumber
     */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * @return retail_price
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * @param retailPrice
     */
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
}