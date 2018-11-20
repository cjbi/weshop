package tech.wetech.weshop.po;

import javax.persistence.*;

@Table(name = "weshop_goods_specification")
public class GoodsSpecificationPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "specification_id")
    private Integer specificationId;

    private String value;

    @Column(name = "pic_url")
    private String picUrl;

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
     * @return specification_id
     */
    public Integer getSpecificationId() {
        return specificationId;
    }

    /**
     * @param specificationId
     */
    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return pic_url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}