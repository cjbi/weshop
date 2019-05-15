package tech.wetech.weshop.goods.po;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "weshop_goods")
public class Goods implements Serializable {
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

    public Goods setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Goods setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public Goods setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
        return this;
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Goods setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public Goods setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public Goods setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public Goods setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
        return this;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public Goods setOnSale(Boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Goods setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public Goods setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Boolean getDelete() {
        return delete;
    }

    public Goods setDelete(Boolean delete) {
        this.delete = delete;
        return this;
    }

    public Integer getAttributeCategory() {
        return attributeCategory;
    }

    public Goods setAttributeCategory(Integer attributeCategory) {
        this.attributeCategory = attributeCategory;
        return this;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public Goods setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
        return this;
    }

    public BigDecimal getExtraPrice() {
        return extraPrice;
    }

    public Goods setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
        return this;
    }

    public Boolean getNewly() {
        return newly;
    }

    public Goods setNewly(Boolean aNew) {
        newly = aNew;
        return this;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public Goods setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
        return this;
    }

    public String getPrimaryPicUrl() {
        return primaryPicUrl;
    }

    public Goods setPrimaryPicUrl(String primaryPicUrl) {
        this.primaryPicUrl = primaryPicUrl;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public Goods setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public Goods setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public Integer getSellVolume() {
        return sellVolume;
    }

    public Goods setSellVolume(Integer sellVolume) {
        this.sellVolume = sellVolume;
        return this;
    }

    public Integer getPrimaryProductId() {
        return primaryProductId;
    }

    public Goods setPrimaryProductId(Integer primaryProductId) {
        this.primaryProductId = primaryProductId;
        return this;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Goods setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public Goods setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
        return this;
    }

    public String getPromotionTag() {
        return promotionTag;
    }

    public Goods setPromotionTag(String promotionTag) {
        this.promotionTag = promotionTag;
        return this;
    }

    public BigDecimal getAppExclusivePrice() {
        return appExclusivePrice;
    }

    public Goods setAppExclusivePrice(BigDecimal appExclusivePrice) {
        this.appExclusivePrice = appExclusivePrice;
        return this;
    }

    public Boolean getAppExclusive() {
        return appExclusive;
    }

    public Goods setAppExclusive(Boolean appExclusive) {
        this.appExclusive = appExclusive;
        return this;
    }

    public Boolean getLimited() {
        return limited;
    }

    public Goods setLimited(Boolean limited) {
        this.limited = limited;
        return this;
    }

    public Boolean getHot() {
        return hot;
    }

    public Goods setHot(Boolean hot) {
        this.hot = hot;
        return this;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public Goods setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
        return this;
    }
}