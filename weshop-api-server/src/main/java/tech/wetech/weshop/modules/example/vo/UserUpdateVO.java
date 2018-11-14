package tech.wetech.weshop.modules.example.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author cjbi
 */
@ApiModel("用户更新对象")
public class UserUpdateVO {

    @ApiModelProperty("编号")
    @NotNull
    private Long id;

    @ApiModelProperty("组织机构编号")
    private Long organizationId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("盐值")
    private String salt;

    @ApiModelProperty("角色列表")
    private String roleIds;

    @ApiModelProperty("组列表")
    private String groupIds;

    @ApiModelProperty("是否锁定")
    private Boolean locked;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组织机构编号
     *
     * @return organization_id - 组织机构编号
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置组织机构编号
     *
     * @param organizationId 组织机构编号
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐值
     *
     * @return salt - 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐值
     *
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取角色列表
     *
     * @return role_ids - 角色列表
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * 设置角色列表
     *
     * @param roleIds 角色列表
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * 获取组列表
     *
     * @return group_ids - 组列表
     */
    public String getGroupIds() {
        return groupIds;
    }

    /**
     * 设置组列表
     *
     * @param groupIds 组列表
     */
    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    /**
     * 获取是否锁定
     *
     * @return locked - 是否锁定
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 设置是否锁定
     *
     * @param locked 是否锁定
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}