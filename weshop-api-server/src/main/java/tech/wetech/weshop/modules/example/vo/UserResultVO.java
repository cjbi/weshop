package tech.wetech.weshop.modules.example.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tech.wetech.weshop.modules.example.po.User;

/**
 * @author cjbi
 */
@ApiModel("用户分页返回对象")
public class UserResultVO {

    @ApiModelProperty("编号")
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

    public UserResultVO(User user) {
        this.id = user.getId();
        this.organizationId = user.getOrganizationId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.salt = user.getSalt();
        this.roleIds = user.getRoleIds();
        this.groupIds = user.getGroupIds();
        this.locked = user.getLocked();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
