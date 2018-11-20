package tech.wetech.weshop.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.enums.GenderEnum;

/**
 * @author cjbi
 */
@ApiModel("用户分页入参对象")
public class UserPageQuery {

    @ApiModelProperty("页面大小")
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    @ApiModelProperty("页码")
    private Integer pageNum = Constants.DEFAULT_PAGE_NUM;

    private String username;

    private String mobile;

    private GenderEnum gender;

    private Byte userLevelId;

    public UserPageQuery() {
    }

    public UserPageQuery(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public Byte getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Byte userLevelId) {
        this.userLevelId = userLevelId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
