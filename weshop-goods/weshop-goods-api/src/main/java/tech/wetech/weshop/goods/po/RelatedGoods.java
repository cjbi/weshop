package tech.wetech.weshop.goods.po;

import javax.persistence.*;

@Table(name = "weshop_related_goods")
public class RelatedGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "related_goods_id")
    private Integer relatedGoodsId;

    public Integer getId() {
        return id;
    }

    public RelatedGoods setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public RelatedGoods setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getRelatedGoodsId() {
        return relatedGoodsId;
    }

    public RelatedGoods setRelatedGoodsId(Integer relatedGoodsId) {
        this.relatedGoodsId = relatedGoodsId;
        return this;
    }
}