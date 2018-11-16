package tech.wetech.weshop.domain;

import javax.persistence.*;

@Table(name = "weshop_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_id")
    private Byte typeId;

    @Column(name = "value_id")
    private Integer valueId;

    /**
     * 储存为base64编码
     */
    private String content;

    @Column(name = "add_time")
    private Long addTime;

    private Byte status;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "new_content")
    private String newContent;

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
     * @return type_id
     */
    public Byte getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
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
     * 获取储存为base64编码
     *
     * @return content - 储存为base64编码
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置储存为base64编码
     *
     * @param content 储存为base64编码
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return add_time
     */
    public Long getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     */
    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    /**
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
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
     * @return new_content
     */
    public String getNewContent() {
        return newContent;
    }

    /**
     * @param newContent
     */
    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }
}