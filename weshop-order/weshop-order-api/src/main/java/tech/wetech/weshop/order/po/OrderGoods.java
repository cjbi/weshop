package tech.wetech.weshop.order.po;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private Boolean real;

    @Column(name = "goods_specification_ids")
    private String goodsSpecificationIds;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    @Column(name = "goods_specification_name_value")
    private String goodsSpecificationNameValue;

    public Integer getId() {
        return id;
    }

    public OrderGoods setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderGoods setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public OrderGoods setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public OrderGoods setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public OrderGoods setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public OrderGoods setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Short getNumber() {
        return number;
    }

    public OrderGoods setNumber(Short number) {
        this.number = number;
        return this;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public OrderGoods setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public OrderGoods setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public Boolean getReal() {
        return real;
    }

    public OrderGoods setReal(Boolean real) {
        this.real = real;
        return this;
    }

    public String getGoodsSpecificationIds() {
        return goodsSpecificationIds;
    }

    public OrderGoods setGoodsSpecificationIds(String goodsSpecificationIds) {
        this.goodsSpecificationIds = goodsSpecificationIds;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public OrderGoods setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public String getGoodsSpecificationNameValue() {
        return goodsSpecificationNameValue;
    }

    public OrderGoods setGoodsSpecificationNameValue(String goodsSpecificationNameValue) {
        this.goodsSpecificationNameValue = goodsSpecificationNameValue;
        return this;
    }
}