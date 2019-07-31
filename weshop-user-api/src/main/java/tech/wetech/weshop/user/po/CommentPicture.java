package tech.wetech.weshop.user.po;

import javax.persistence.*;

@Table(name = "weshop_comment_picture")
public class CommentPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "sort_order")
    private Boolean sortOrder;

    public Integer getId() {
        return id;
    }

    public CommentPicture setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public CommentPicture setCommentId(Integer commentId) {
        this.commentId = commentId;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public CommentPicture setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public Boolean getSortOrder() {
        return sortOrder;
    }

    public CommentPicture setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }
}
