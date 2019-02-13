package tech.wetech.weshop.order.po;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "weshop_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_sn")
    private String goodsSn;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    private Short number;

    /**
     * product表对应的goods_specification_ids
     */
    @Column(name = "goods_specification_ids")
    private String goodsSpecificationIds;

    private Boolean checked;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    /**
     * 规格属性组成的字符串，用来显示用
     */
    @Column(name = "goods_specification_name_value")
    private String goodsSpecificationNameValue;

    public Integer getId() {
        return id;
    }

    public Cart setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Cart setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Cart setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Cart setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public Cart setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public Cart setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Cart setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public Cart setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public Cart setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public Short getNumber() {
        return number;
    }

    public Cart setNumber(Short number) {
        this.number = number;
        return this;
    }

    public String getGoodsSpecificationIds() {
        return goodsSpecificationIds;
    }

    public Cart setGoodsSpecificationIds(String goodsSpecificationIds) {
        this.goodsSpecificationIds = goodsSpecificationIds;
        return this;
    }

    public Boolean getChecked() {
        return checked;
    }

    public Cart setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public Cart setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public String getGoodsSpecificationNameValue() {
        return goodsSpecificationNameValue;
    }

    public Cart setGoodsSpecificationNameValue(String goodsSpecificationNameValue) {
        this.goodsSpecificationNameValue = goodsSpecificationNameValue;
        return this;
    }
}