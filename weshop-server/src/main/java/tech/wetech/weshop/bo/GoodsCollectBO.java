package tech.wetech.weshop.bo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GoodsCollectBO {

    private Integer id;

    private Integer userId;

    private Integer valueId;

    private LocalDateTime createTime;
    /**
     * 是否是关注
     */
    private Boolean attention;

    private Integer typeId;

    private String name;

    private String listPicUrl;

    private String goodsBrief;

    private BigDecimal retailPrice;

    public Integer getId() {
        return id;
    }

    public GoodsCollectBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public GoodsCollectBO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public GoodsCollectBO setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public GoodsCollectBO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public Boolean getAttention() {
        return attention;
    }

    public GoodsCollectBO setAttention(Boolean attention) {
        this.attention = attention;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public GoodsCollectBO setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsCollectBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public GoodsCollectBO setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public GoodsCollectBO setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public GoodsCollectBO setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }
}
