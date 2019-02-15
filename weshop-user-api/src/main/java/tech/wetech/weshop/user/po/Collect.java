package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.util.Date;

@Table(name = "weshop_collect")
public class Collect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "value_id")
    private Integer valueId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否是关注
     */
    @Column(name = "is_attention")
    private Boolean attention;

    @Column(name = "type_id")
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public Collect setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Collect setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public Collect setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Collect setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Boolean getAttention() {
        return attention;
    }

    public Collect setAttention(Boolean attention) {
        this.attention = attention;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Collect setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }
}