package tech.wetech.weshop.vo;

import com.github.pagehelper.PageInfo;

public class Pagination {

    private int current;

    private int pageSize;

    private long total;

    public Pagination(PageInfo pageInfo) {
        this.current = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
