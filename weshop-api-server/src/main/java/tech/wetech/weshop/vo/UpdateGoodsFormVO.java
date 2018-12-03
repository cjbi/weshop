package tech.wetech.weshop.vo;

import java.math.BigDecimal;
import java.util.Date;

public class UpdateGoodsFormVO {
    private Integer id;

    private Integer categoryId;

    private String goodsSn;

    private String name;

    private Integer brandId;

    private Integer goodsNumber;

    private String keywords;

    private String goodsBrief;

    private Boolean isOnSale;

    private Date createTime;

    private Short sortOrder;

    private Boolean isDelete;

    private Integer attributeCategory;

    /**
     * 专柜价格
     */
    private BigDecimal counterPrice;

    /**
     * 附加价格
     */
    private BigDecimal extraPrice;

    private Boolean isNew;

    /**
     * 商品单位
     */
    private String goodsUnit;

    /**
     * 商品主图
     */
    private String primaryPicUrl;

    /**
     * 商品列表图
     */
    private String listPicUrl;

    /**
     * 零售价格
     */
    private BigDecimal retailPrice;

    /**
     * 销售量
     */
    private Integer sellVolume;

    /**
     * 主sku　product_id
     */
    private Integer primaryProductId;

    /**
     * 单位价格，单价
     */
    private BigDecimal unitPrice;

    private String promotionDesc;

    private String promotionTag;

    /**
     * APP专享价
     */
    private BigDecimal appExclusivePrice;

    /**
     * 是否是APP专属
     */
    private Boolean isAppExclusive;

    private Boolean isLimited;

    private Boolean isHot;

    private String goodsDesc;

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
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return brand_id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * @param brandId
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return goods_brief
     */
    public String getGoodsBrief() {
        return goodsBrief;
    }

    /**
     * @param goodsBrief
     */
    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    /**
     * @return is_on_sale
     */
    public Boolean getIsOnSale() {
        return isOnSale;
    }

    /**
     * @param isOnSale
     */
    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return sort_order
     */
    public Short getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder
     */
    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return is_delete
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return attribute_category
     */
    public Integer getAttributeCategory() {
        return attributeCategory;
    }

    /**
     * @param attributeCategory
     */
    public void setAttributeCategory(Integer attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    /**
     * 获取专柜价格
     *
     * @return counter_price - 专柜价格
     */
    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    /**
     * 设置专柜价格
     *
     * @param counterPrice 专柜价格
     */
    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    /**
     * 获取附加价格
     *
     * @return extra_price - 附加价格
     */
    public BigDecimal getExtraPrice() {
        return extraPrice;
    }

    /**
     * 设置附加价格
     *
     * @param extraPrice 附加价格
     */
    public void setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
    }

    /**
     * @return is_new
     */
    public Boolean getIsNew() {
        return isNew;
    }

    /**
     * @param isNew
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     * 获取商品单位
     *
     * @return goods_unit - 商品单位
     */
    public String getGoodsUnit() {
        return goodsUnit;
    }

    /**
     * 设置商品单位
     *
     * @param goodsUnit 商品单位
     */
    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    /**
     * 获取商品主图
     *
     * @return primary_pic_url - 商品主图
     */
    public String getPrimaryPicUrl() {
        return primaryPicUrl;
    }

    /**
     * 设置商品主图
     *
     * @param primaryPicUrl 商品主图
     */
    public void setPrimaryPicUrl(String primaryPicUrl) {
        this.primaryPicUrl = primaryPicUrl;
    }

    /**
     * 获取商品列表图
     *
     * @return list_pic_url - 商品列表图
     */
    public String getListPicUrl() {
        return listPicUrl;
    }

    /**
     * 设置商品列表图
     *
     * @param listPicUrl 商品列表图
     */
    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    /**
     * 获取零售价格
     *
     * @return retail_price - 零售价格
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * 设置零售价格
     *
     * @param retailPrice 零售价格
     */
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获取销售量
     *
     * @return sell_volume - 销售量
     */
    public Integer getSellVolume() {
        return sellVolume;
    }

    /**
     * 设置销售量
     *
     * @param sellVolume 销售量
     */
    public void setSellVolume(Integer sellVolume) {
        this.sellVolume = sellVolume;
    }

    /**
     * 获取主sku　product_id
     *
     * @return primary_product_id - 主sku　product_id
     */
    public Integer getPrimaryProductId() {
        return primaryProductId;
    }

    /**
     * 设置主sku　product_id
     *
     * @param primaryProductId 主sku　product_id
     */
    public void setPrimaryProductId(Integer primaryProductId) {
        this.primaryProductId = primaryProductId;
    }

    /**
     * 获取单位价格，单价
     *
     * @return unit_price - 单位价格，单价
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置单位价格，单价
     *
     * @param unitPrice 单位价格，单价
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return promotion_desc
     */
    public String getPromotionDesc() {
        return promotionDesc;
    }

    /**
     * @param promotionDesc
     */
    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }

    /**
     * @return promotion_tag
     */
    public String getPromotionTag() {
        return promotionTag;
    }

    /**
     * @param promotionTag
     */
    public void setPromotionTag(String promotionTag) {
        this.promotionTag = promotionTag;
    }

    /**
     * 获取APP专享价
     *
     * @return app_exclusive_price - APP专享价
     */
    public BigDecimal getAppExclusivePrice() {
        return appExclusivePrice;
    }

    /**
     * 设置APP专享价
     *
     * @param appExclusivePrice APP专享价
     */
    public void setAppExclusivePrice(BigDecimal appExclusivePrice) {
        this.appExclusivePrice = appExclusivePrice;
    }

    /**
     * 获取是否是APP专属
     *
     * @return is_app_exclusive - 是否是APP专属
     */
    public Boolean getIsAppExclusive() {
        return isAppExclusive;
    }

    /**
     * 设置是否是APP专属
     *
     * @param isAppExclusive 是否是APP专属
     */
    public void setIsAppExclusive(Boolean isAppExclusive) {
        this.isAppExclusive = isAppExclusive;
    }

    /**
     * @return is_limited
     */
    public Boolean getIsLimited() {
        return isLimited;
    }

    /**
     * @param isLimited
     */
    public void setIsLimited(Boolean isLimited) {
        this.isLimited = isLimited;
    }

    /**
     * @return is_hot
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    /**
     * @return goods_desc
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * @param goodsDesc
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}