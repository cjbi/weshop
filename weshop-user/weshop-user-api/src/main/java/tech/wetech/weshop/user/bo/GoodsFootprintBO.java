package tech.wetech.weshop.user.bo;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    public String getDisplayTime() {
        if (LocalDate.now().isEqual(createTime)) {
            return "今天";
        }
        if (LocalDate.now().minusDays(1).isEqual(createTime)) {
            return "昨天";
        }
        if (LocalDate.now().minusDays(2).isEqual(createTime)) {
            return "前天";
        }
        return createTime.toString();
    }

}
