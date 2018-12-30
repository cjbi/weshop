package tech.wetech.weshop.query;

public class OrderQuery {

    private Integer pageNum;

    private Integer PageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public OrderQuery setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public OrderQuery setPageSize(Integer pageSize) {
        PageSize = pageSize;
        return this;
    }
}
