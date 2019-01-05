package tech.wetech.weshop.bo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class GoodsFootprintBO {

    private Integer id;

    private Integer userId;

    private Integer goodsId;

    private LocalDate createTime;

    private String name;

    private String listPicUrl;

    private String goodsBrief;

    private BigDecimal retailPrice;

    public Integer getId() {
        return id;
    }

    public GoodsFootprintBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public GoodsFootprintBO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public GoodsFootprintBO setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public GoodsFootprintBO setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsFootprintBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public GoodsFootprintBO setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public GoodsFootprintBO setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public GoodsFootprintBO setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsFootprintBO)) return false;
        GoodsFootprintBO that = (GoodsFootprintBO) o;
        return Objects.equals(getGoodsId(), that.getGoodsId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getGoodsId(), getCreateTime(), getName(), getListPicUrl(), getGoodsBrief(), getRetailPrice());
    }
}
