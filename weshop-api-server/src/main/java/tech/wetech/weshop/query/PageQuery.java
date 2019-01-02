package tech.wetech.weshop.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 分页查询
 */
@ApiModel("分页查询")
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 页码，从1开始
     */
    @ApiModelProperty("页码，从1开始")
    private Integer pageNum;
    /**
     * 页面大小
     */
    @ApiModelProperty("页面大小")
    private Integer pageSize;
    /**
     * 包含count查询
     */
    @ApiModelProperty("包含count查询")
    private Boolean countSql = true;
    /**
     * 分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。
     */
    @ApiModelProperty("分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。")
    private Boolean reasonable;
    /**
     * 当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
     */
    @ApiModelProperty("当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果")
    private Boolean pageSizeZero;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private String orderBy;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getCountSql() {
        return countSql;
    }

    public void setCountSql(Boolean countSql) {
        this.countSql = countSql;
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", countSql=" + countSql +
                ", reasonable=" + reasonable +
                ", pageSizeZero=" + pageSizeZero +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }
}
