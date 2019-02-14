package tech.wetech.weshop.marketing.dto;

import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.utils.Constants;

import javax.validation.constraints.NotNull;
import java.util.Base64;

public class CommentPostDTO {

    @NotNull
    private Byte typeId;

    @NotNull
    private Integer valueId;

    /**
     * 储存为base64编码
     */
    @NotNull
    private String content;

    @NotNull
    private Integer userId;

    public Comment toPO() {
        Comment comment = new Comment();
        comment.setTypeId(typeId);
        comment.setValueId(valueId);
        comment.setContent(Base64.getEncoder().encodeToString(content.getBytes()));
        comment.setUserId(Constants.CURRENT_USER_ID);
        return comment;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public CommentPostDTO setTypeId(Byte typeId) {
        this.typeId = typeId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public CommentPostDTO setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentPostDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public CommentPostDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

}
