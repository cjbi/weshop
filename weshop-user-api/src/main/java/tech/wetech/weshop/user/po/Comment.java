package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "create_time")
    private LocalDateTime createTime;

    private Byte status;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "new_content")
    private String newContent;

    public Integer getId() {
        return id;
    }

    public Comment setId(Integer id) {
        this.id = id;
        return this;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public Comment setTypeId(Byte typeId) {
        this.typeId = typeId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public Comment setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Comment setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public Byte getStatus() {
        return status;
    }

    public Comment setStatus(Byte status) {
        this.status = status;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Comment setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getNewContent() {
        return newContent;
    }

    public Comment setNewContent(String newContent) {
        this.newContent = newContent;
        return this;
    }
}
