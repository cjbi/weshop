package tech.wetech.weshop.goods.po;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "weshop_brand")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    @Column(name = "simple_desc")
    private String simpleDesc;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "sort_order")
    private Byte sortOrder;

    @Column(name = "is_show")
    private Boolean show;

    @Column(name = "floor_price")
    private BigDecimal floorPrice;

    @Column(name = "app_list_pic_url")
    private String appListPicUrl;

    @Column(name = "is_new")
    private Boolean newly;

    @Column(name = "new_pic_url")
    private String newPicUrl;

    @Column(name = "new_sort_order")
    private Byte newSortOrder;

    public Integer getId() {
        return id;
    }

    public Brand setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public Brand setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
        return this;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public Brand setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public Brand setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public Brand setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public Brand setShow(Boolean show) {
        this.show = show;
        return this;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public Brand setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
        return this;
    }

    public String getAppListPicUrl() {
        return appListPicUrl;
    }

    public Brand setAppListPicUrl(String appListPicUrl) {
        this.appListPicUrl = appListPicUrl;
        return this;
    }

    public Boolean getNewly() {
        return newly;
    }

    public Brand setNewly(Boolean newly) {
        this.newly = newly;
        return this;
    }

    public String getNewPicUrl() {
        return newPicUrl;
    }

    public Brand setNewPicUrl(String newPicUrl) {
        this.newPicUrl = newPicUrl;
        return this;
    }

    public Byte getNewSortOrder() {
        return newSortOrder;
    }

    public Brand setNewSortOrder(Byte newSortOrder) {
        this.newSortOrder = newSortOrder;
        return this;
    }
}