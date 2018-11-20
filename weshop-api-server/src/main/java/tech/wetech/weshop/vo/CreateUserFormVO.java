package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.User;
import tech.wetech.weshop.enums.GenderEnum;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateUserFormVO {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private GenderEnum gender;

    private Date birthday;

    private Date registerTime;

    private Date lastLoginTime;

    private String lastLoginIp;


    private Byte userLevelId;

    private String nickname;

    @NotNull
    private String mobile;

    private String registerIp;

    private String avatar;

    private String wechatOpenId;

    public CreateUserFormVO() {
    }

    public CreateUserFormVO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.gender = user.getGender();
        this.birthday = user.getBirthday();
        this.registerTime = user.getRegisterTime();
        this.lastLoginTime = user.getLastLoginTime();
        this.lastLoginIp = user.getLastLoginIp();
        this.userLevelId = user.getUserLevelId();
        this.nickname = user.getNickname();
        this.mobile = user.getMobile();
        this.registerIp = user.getRegisterIp();
        this.avatar = user.getAvatar();
        this.wechatOpenId = user.getWechatOpenId();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Byte getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Byte userLevelId) {
        this.userLevelId = userLevelId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }
}
