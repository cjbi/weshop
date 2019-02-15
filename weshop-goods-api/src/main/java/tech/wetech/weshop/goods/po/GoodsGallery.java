package tech.wetech.weshop.goods.po;

import javax.persistence.*;

@Table(name = "weshop_goods_gallery")
public class GoodsGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_desc")
    private String imgDesc;

    @Column(name = "sort_order")
    private Integer sortOrder;

    public Integer getId() {
        return id;
    }

    public GoodsGallery setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public GoodsGallery setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public GoodsGallery setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public GoodsGallery setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
        return this;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public GoodsGallery setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }
}