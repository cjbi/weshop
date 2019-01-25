package tech.wetech.weshop.wechat.dto;

import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.po.User;

import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

public class CommentResultDTO {

    private Integer id;

    private String content;

    private Integer typeId;

    private Integer valueId;

    private Integer userId;

    private String createTime;

    private UserInfoVO userInfo;

    private List<String> picList;

    public CommentResultDTO(Comment comment) {
        this.id = comment.getId();
        try {
            this.content = new String(Base64.getDecoder().decode(comment.getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.typeId = comment.getTypeId().intValue();
        this.valueId = comment.getValueId();
        this.userId = comment.getUserId();
        this.createTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(comment.getCreateTime());
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

    public CommentResultDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentResultDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public CommentResultDTO setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public CommentResultDTO setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public UserInfoVO getUserInfo() {
        return userInfo;
    }

    public CommentResultDTO setUserInfo(UserInfoVO userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public List<String> getPicList() {
        return picList;
    }

    public CommentResultDTO setPicList(List<String> picList) {
        this.picList = picList;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public CommentResultDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
