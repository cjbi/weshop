package tech.wetech.weshop.po;

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
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return related_goods_id
     */
    public Integer getRelatedGoodsId() {
        return relatedGoodsId;
    }

    /**
     * @param relatedGoodsId
     */
    public void setRelatedGoodsId(Integer relatedGoodsId) {
        this.relatedGoodsId = relatedGoodsId;
    }
}