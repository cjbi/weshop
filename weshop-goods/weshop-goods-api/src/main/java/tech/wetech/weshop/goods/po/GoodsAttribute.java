package tech.wetech.weshop.goods.po;

import javax.persistence.*;

@Table(name = "weshop_goods_attribute")
public class GoodsAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "attribute_id")
    private Integer attributeId;

    private String value;

    public Integer getId() {
        return id;
    }

    public GoodsAttribute setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public GoodsAttribute setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public GoodsAttribute setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsAttribute setValue(String value) {
        this.value = value;
        return this;
    }
}