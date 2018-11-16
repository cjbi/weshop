package tech.wetech.weshop.domain;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "weshop_order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_sn")
    private String goodsSn;

    @Column(name = "product_id")
    private Integer productId;

    private Short number;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    @Column(name = "is_real")
    private Boolean isReal;

    @Column(name = "goods_specifition_ids")
    private String goodsSpecifitionIds;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    @Column(name = "goods_specifition_name_value")
    private String goodsSpecifitionNameValue;

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
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
     * @return goods_name
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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
     * @return product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return number
     */
    public Short getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Short number) {
        this.number = number;
    }

    /**
     * @return market_price
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * @param marketPrice
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
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

    /**
     * @return is_real
     */
    public Boolean getIsReal() {
        return isReal;
    }

    /**
     * @param isReal
     */
    public void setIsReal(Boolean isReal) {
        this.isReal = isReal;
    }

    /**
     * @return goods_specifition_ids
     */
    public String getGoodsSpecifitionIds() {
        return goodsSpecifitionIds;
    }

    /**
     * @param goodsSpecifitionIds
     */
    public void setGoodsSpecifitionIds(String goodsSpecifitionIds) {
        this.goodsSpecifitionIds = goodsSpecifitionIds;
    }

    /**
     * @return list_pic_url
     */
    public String getListPicUrl() {
        return listPicUrl;
    }

    /**
     * @param listPicUrl
     */
    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    /**
     * @return goods_specifition_name_value
     */
    public String getGoodsSpecifitionNameValue() {
        return goodsSpecifitionNameValue;
    }

    /**
     * @param goodsSpecifitionNameValue
     */
    public void setGoodsSpecifitionNameValue(String goodsSpecifitionNameValue) {
        this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
    }
}