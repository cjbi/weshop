package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.util.Date;

@Table(name = "weshop_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @Column(name = "password_salt")
    private String passwordSalt;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private String avatar;

    @Column(name = "admin_role_id")
    private Integer adminRoleId;

    public Integer getId() {
        return id;
    }

    public Admin setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Admin setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public Admin setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
        return this;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public Admin setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public Admin setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Admin setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Admin setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public Admin setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public Admin setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
        return this;
    }
}