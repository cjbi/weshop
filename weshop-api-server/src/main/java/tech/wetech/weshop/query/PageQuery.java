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
    private int pageNum;
    /**
     * 页面大小
     */
    @ApiModelProperty("页面大小")
    private int pageSize;
    /**
     * 起始行
     */
    @ApiModelProperty("起始行")
    private int startRow;
    /**
     * 末行
     */
    @ApiModelProperty("末行")
    private int endRow;
    /**
     * 总页数
     */
    @ApiModelProperty("总页数")
    private int pages;
    /**
     * 包含count查询
     */
    @ApiModelProperty("包含count查询")
    private boolean count = true;
    /**
     * 分页合理化
     */
    @ApiModelProperty("分页合理化")
    private Boolean reasonable;
    /**
     * 当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
     */
    @ApiModelProperty("当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果")
    private Boolean pageSizeZero;
    /**
     * 进行count查询的列名
     */
    @ApiModelProperty("起始行")
    private String countColumn;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private String orderBy;
    /**
     * 只增加排序
     */
    @ApiModelProperty("只增加排序")
    private boolean orderByOnly;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPageNum() {
        return pageNum;
    }

    public PageQuery setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageQuery setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getStartRow() {
        return startRow;
    }

    public PageQuery setStartRow(int startRow) {
        this.startRow = startRow;
        return this;
    }

    public int getEndRow() {
        return endRow;
    }

    public PageQuery setEndRow(int endRow) {
        this.endRow = endRow;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public PageQuery setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public boolean isCount() {
        return count;
    }

    public PageQuery setCount(boolean count) {
        this.count = count;
        return this;
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public PageQuery setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
        return this;
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public PageQuery setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
        return this;
    }

    public String getCountColumn() {
        return countColumn;
    }

    public PageQuery setCountColumn(String countColumn) {
        this.countColumn = countColumn;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public PageQuery setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public boolean isOrderByOnly() {
        return orderByOnly;
    }

    public PageQuery setOrderByOnly(boolean orderByOnly) {
        this.orderByOnly = orderByOnly;
        return this;
    }

    @Override
    public String toString() {
        return "Page{" +
                "count=" + count +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", pages=" + pages +
                ", reasonable=" + reasonable +
                ", pageSizeZero=" + pageSizeZero +
                '}';
    }
}
