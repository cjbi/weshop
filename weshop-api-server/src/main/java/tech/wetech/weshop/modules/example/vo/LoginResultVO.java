package tech.wetech.weshop.modules.example.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录返回参数")
public class LoginResultVO {

    @ApiModelProperty("令牌")
    String token;

    public LoginResultVO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
