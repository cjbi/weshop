package tech.wetech.weshop.domain;

import java.util.Date;
import javax.persistence.*;

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
    private Boolean isAttention;

    @Column(name = "type_id")
    private Integer typeId;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return value_id
     */
    public Integer getValueId() {
        return valueId;
    }

    /**
     * @param valueId
     */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否是关注
     *
     * @return is_attention - 是否是关注
     */
    public Boolean getIsAttention() {
        return isAttention;
    }

    /**
     * 设置是否是关注
     *
     * @param isAttention 是否是关注
     */
    public void setIsAttention(Boolean isAttention) {
        this.isAttention = isAttention;
    }

    /**
     * @return type_id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}