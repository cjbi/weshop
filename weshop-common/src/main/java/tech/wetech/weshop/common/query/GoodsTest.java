package tech.wetech.weshop.common.query;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "weshop_goods")
public class GoodsTest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "goods_sn")
    private String goodsSn;

    private String name;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "goods_number")
    private Integer goodsNumber;

    private String keywords;

    @Column(name = "goods_brief")
    private String goodsBrief;

    @Column(name = "is_on_sale")
    private Boolean onSale;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "sort_order")
    private Short sortOrder;

    @Column(name = "is_delete")
    private Boolean delete;

    @Column(name = "attribute_category")
    private Integer attributeCategory;

    /**
     * 专柜价格
     */
    @Column(name = "counter_price")
    private BigDecimal counterPrice;

    /**
     * 附加价格
     */
    @Column(name = "extra_price")
    private BigDecimal extraPrice;

    @Column(name = "is_new")
    private Boolean newly;

    /**
     * 商品单位
     */
    @Column(name = "goods_unit")
    private String goodsUnit;

    /**
     * 商品主图
     */
    @Column(name = "primary_pic_url")
    private String primaryPicUrl;

    /**
     * 商品列表图
     */
    @Column(name = "list_pic_url")
    private String listPicUrl;

    /**
     * 零售价格
     */
    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    /**
     * 销售量
     */
    @Column(name = "sell_volume")
    private Integer sellVolume;

    /**
     * 主sku　product_id
     */
    @Column(name = "primary_product_id")
    private Integer primaryProductId;

    /**
     * 单位价格，单价
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "promotion_desc")
    private String promotionDesc;

    @Column(name = "promotion_tag")
    private String promotionTag;

    /**
     * APP专享价
     */
    @Column(name = "app_exclusive_price")
    private BigDecimal appExclusivePrice;

    /**
     * 是否是APP专属
     */
    @Column(name = "is_app_exclusive")
    private Boolean appExclusive;

    @Column(name = "is_limited")
    private Boolean limited;

    @Column(name = "is_hot")
    private Boolean hot;

    @Column(name = "goods_desc")
    private String goodsDesc;

    public Integer getId() {
        return id;
    }

    public GoodsTest setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public GoodsTest setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public GoodsTest setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsTest setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public GoodsTest setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public GoodsTest setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public GoodsTest setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public GoodsTest setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
        return this;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public GoodsTest setOnSale(Boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public GoodsTest setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public GoodsTest setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Boolean getDelete() {
        return delete;
    }

    public GoodsTest setDelete(Boolean delete) {
        this.delete = delete;
        return this;
    }

    public Integer getAttributeCategory() {
        return attributeCategory;
    }

    public GoodsTest setAttributeCategory(Integer attributeCategory) {
        this.attributeCategory = attributeCategory;
        return this;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public GoodsTest setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
        return this;
    }

    public BigDecimal getExtraPrice() {
        return extraPrice;
    }

    public GoodsTest setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
        return this;
    }

    public Boolean getNewly() {
        return newly;
    }

    public GoodsTest setNewly(Boolean aNew) {
        newly = aNew;
        return this;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public GoodsTest setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
        return this;
    }

    public String getPrimaryPicUrl() {
        return primaryPicUrl;
    }

    public GoodsTest setPrimaryPicUrl(String primaryPicUrl) {
        this.primaryPicUrl = primaryPicUrl;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public GoodsTest setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public GoodsTest setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public Integer getSellVolume() {
        return sellVolume;
    }

    public GoodsTest setSellVolume(Integer sellVolume) {
        this.sellVolume = sellVolume;
        return this;
    }

    public Integer getPrimaryProductId() {
        return primaryProductId;
    }

    public GoodsTest setPrimaryProductId(Integer primaryProductId) {
        this.primaryProductId = primaryProductId;
        return this;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public GoodsTest setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public GoodsTest setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
        return this;
    }

    public String getPromotionTag() {
        return promotionTag;
    }

    public GoodsTest setPromotionTag(String promotionTag) {
        this.promotionTag = promotionTag;
        return this;
    }

    public BigDecimal getAppExclusivePrice() {
        return appExclusivePrice;
    }

    public GoodsTest setAppExclusivePrice(BigDecimal appExclusivePrice) {
        this.appExclusivePrice = appExclusivePrice;
        return this;
    }

    public Boolean getAppExclusive() {
        return appExclusive;
    }

    public GoodsTest setAppExclusive(Boolean appExclusive) {
        this.appExclusive = appExclusive;
        return this;
    }

    public Boolean getLimited() {
        return limited;
    }

    public GoodsTest setLimited(Boolean limited) {
        this.limited = limited;
        return this;
    }

    public Boolean getHot() {
        return hot;
    }

    public GoodsTest setHot(Boolean hot) {
        this.hot = hot;
        return this;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public GoodsTest setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
        return this;
    }
}