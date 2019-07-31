package tech.wetech.weshop.user.query;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class CommentQuery {

    @NotNull
    private Integer typeId;

    @NotNull
    private Integer valueId;

    private boolean requirePicture;

    /**
     * 页码，从1开始
     */
    @ApiModelProperty("页码，从1开始")
    private int pageNum;
    /**
     * 页面大小
     */
    @ApiModelProperty("页面大小")
    private int pageSize;

    public Integer getTypeId() {
        return typeId;
    }

    public CommentQuery setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public CommentQuery setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public boolean getRequirePicture() {
        return requirePicture;
    }

    public CommentQuery setRequirePicture(boolean requirePicture) {
        this.requirePicture = requirePicture;
        return this;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
