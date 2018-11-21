package tech.wetech.weshop.po;

import tech.wetech.weshop.enums.GenderEnum;
import tech.wetech.weshop.vo.CreateUserFormVO;
import tech.wetech.weshop.vo.UpdateUserFormVO;
import tk.mybatis.mapper.annotation.ColumnType;

import java.util.Date;
import javax.persistence.*;

@Table(name = "weshop_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @ColumnType
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

    public User() {
    }

    public User(CreateUserFormVO user) {
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

    public User(UpdateUserFormVO user) {
        this.id = user.getId();
        this.username = user.getUsername();
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return gender
     */
    public GenderEnum getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return register_time
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * @param registerTime
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return last_login_ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * @return user_level_id
     */
    public Byte getUserLevelId() {
        return userLevelId;
    }

    /**
     * @param userLevelId
     */
    public void setUserLevelId(Byte userLevelId) {
        this.userLevelId = userLevelId;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return register_ip
     */
    public String getRegisterIp() {
        return registerIp;
    }

    /**
     * @param registerIp
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return wechat_open_id
     */
    public String getWechatOpenId() {
        return wechatOpenId;
    }

    /**
     * @param wechatOpenId
     */
    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }
}