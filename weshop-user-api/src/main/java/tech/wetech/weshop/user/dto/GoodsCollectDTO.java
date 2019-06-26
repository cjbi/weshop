package tech.wetech.weshop.user.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GoodsCollectDTO {

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

    public GoodsCollectDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public GoodsCollectDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public GoodsCollectDTO setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public GoodsCollectDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public Boolean getAttention() {
        return attention;
    }

    public GoodsCollectDTO setAttention(Boolean attention) {
        this.attention = attention;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public GoodsCollectDTO setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsCollectDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public GoodsCollectDTO setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public GoodsCollectDTO setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public GoodsCollectDTO setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }
}
