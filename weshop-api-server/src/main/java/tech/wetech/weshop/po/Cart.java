package tech.wetech.weshop.po;

import java.math.BigDecimal;
import javax.persistence.*;

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
     * product表对应的goods_specifition_ids
     */
    @Column(name = "goods_specifition_ids")
    private String goodsSpecifitionIds;

    private Boolean checked;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    /**
     * 规格属性组成的字符串，用来显示用
     */
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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return session_id
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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
     * 获取product表对应的goods_specifition_ids
     *
     * @return goods_specifition_ids - product表对应的goods_specifition_ids
     */
    public String getGoodsSpecifitionIds() {
        return goodsSpecifitionIds;
    }

    /**
     * 设置product表对应的goods_specifition_ids
     *
     * @param goodsSpecifitionIds product表对应的goods_specifition_ids
     */
    public void setGoodsSpecifitionIds(String goodsSpecifitionIds) {
        this.goodsSpecifitionIds = goodsSpecifitionIds;
    }

    /**
     * @return checked
     */
    public Boolean getChecked() {
        return checked;
    }

    /**
     * @param checked
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
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
     * 获取规格属性组成的字符串，用来显示用
     *
     * @return goods_specifition_name_value - 规格属性组成的字符串，用来显示用
     */
    public String getGoodsSpecifitionNameValue() {
        return goodsSpecifitionNameValue;
    }

    /**
     * 设置规格属性组成的字符串，用来显示用
     *
     * @param goodsSpecifitionNameValue 规格属性组成的字符串，用来显示用
     */
    public void setGoodsSpecifitionNameValue(String goodsSpecifitionNameValue) {
        this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
    }
}