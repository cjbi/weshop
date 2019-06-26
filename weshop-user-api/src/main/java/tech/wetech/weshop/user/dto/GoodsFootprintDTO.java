package tech.wetech.weshop.user.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GoodsFootprintDTO {

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

    public GoodsFootprintDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public GoodsFootprintDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public GoodsFootprintDTO setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public GoodsFootprintDTO setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsFootprintDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public GoodsFootprintDTO setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public GoodsFootprintDTO setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
        return this;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public GoodsFootprintDTO setRetailPrice(BigDecimal retailPrice) {
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
