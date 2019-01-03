package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.po.User;

import java.util.Date;
import java.util.List;

public class CommentResultVO {

    private Integer id;

    private String content;

    private Integer typeId;

    private Integer valueId;

    private Integer userId;

    private Date createTime;

    private UserInfoVO userInfo;

    private List<String> picList;

    public CommentResultVO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.typeId = comment.getTypeId().intValue();
        this.valueId = comment.getValueId();
        this.userId = comment.getUserId();
        this.createTime = comment.getCreateTime();
    }

    public static class UserInfoVO {

        private String username;

        private String avatar;

        private String nickname;

        public UserInfoVO(User user) {
            this.username = user.getUsername();
            this.avatar = user.getAvatar();
            this.nickname = user.getNickname();
        }

        public String getUsername() {
            return username;
        }

        public UserInfoVO setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getAvatar() {
            return avatar;
        }

        public UserInfoVO setAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public String getNickname() {
            return nickname;
        }

        public UserInfoVO setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }
    }

    public Integer getId() {
        return id;
    }

    public CommentResultVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentResultVO setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public CommentResultVO setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public CommentResultVO setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public CommentResultVO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public UserInfoVO getUserInfo() {
        return userInfo;
    }

    public CommentResultVO setUserInfo(UserInfoVO userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public List<String> getPicList() {
        return picList;
    }

    public CommentResultVO setPicList(List<String> picList) {
        this.picList = picList;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public CommentResultVO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
