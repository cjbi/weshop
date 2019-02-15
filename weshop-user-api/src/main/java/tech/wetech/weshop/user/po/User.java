package tech.wetech.weshop.user.po;

import tech.wetech.weshop.user.enums.GenderEnum;

import javax.persistence.*;
import java.util.Date;

@Table(name = "weshop_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @Column(name = "gender")
    private GenderEnum gender;

    private Date birthday;

    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "user_level_id")
    private Byte userLevelId;

    private String nickname;

    private String mobile;

    @Column(name = "register_ip")
    private String registerIp;

    private String avatar;

    @Column(name = "wechat_open_id")
    private String wechatOpenId;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public User setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public User setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public User setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public User setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
        return this;
    }

    public Byte getUserLevelId() {
        return userLevelId;
    }

    public User setUserLevelId(Byte userLevelId) {
        this.userLevelId = userLevelId;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public User setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public User setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
        return this;
    }
}