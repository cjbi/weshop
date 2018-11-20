package tech.wetech.weshop.query;

import io.swagger.annotations.ApiModelProperty;
import tech.wetech.weshop.utils.Constants;

/**
 * @author cjbi
 */
public class FeedbackPageQuery {

    @ApiModelProperty("页面大小")
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    @ApiModelProperty("页码")
    private Integer pageNum = Constants.DEFAULT_PAGE_NUM;

    private Integer userId;

    private Integer msgId;

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

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }
}
