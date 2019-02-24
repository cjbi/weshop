package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "weshop_footprint")
public class Footprint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public Footprint setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Footprint setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Footprint setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Footprint setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Footprint{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", createTime=" + createTime +
                '}';
    }
}