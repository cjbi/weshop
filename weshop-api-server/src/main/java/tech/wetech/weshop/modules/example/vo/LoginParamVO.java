package tech.wetech.weshop.modules.example.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author cjbi
 */
@ApiModel("登录请求参数")
public class LoginParamVO {

    @ApiModelProperty("用户名")
    @NotNull
    String userName;

    @ApiModelProperty("密码")
    @NotNull
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}