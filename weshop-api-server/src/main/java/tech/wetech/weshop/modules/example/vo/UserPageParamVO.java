package tech.wetech.weshop.modules.example.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author cjbi
 */
@ApiModel("用户分页入参对象")
public class UserPageParamVO {

    @ApiModelProperty("页面大小")
    private Integer pageSize = 10;

    @ApiModelProperty("页码")
    private Integer pageNum = 1;

    private String username;

    public UserPageParamVO() {
    }

    public UserPageParamVO(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
