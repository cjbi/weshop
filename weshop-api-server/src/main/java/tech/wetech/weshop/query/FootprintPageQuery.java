package tech.wetech.weshop.query;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author cjbi
 */
public class FootprintPageQuery {

    @ApiModelProperty("页面大小")
    private Integer pageSize = 10;

    @ApiModelProperty("页码")
    private Integer pageNum = 1;

    private Integer userId;

    private Integer goodsId;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
