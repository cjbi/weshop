package tech.wetech.weshop.query;

public class PageQueryWrapper<T> {

    private PageQuery pageQuery;

    private T data;

    public PageQueryWrapper() {
    }

    public PageQueryWrapper(PageQuery pageQuery, T data) {
        this.pageQuery = pageQuery;
        this.data = data;
    }

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public PageQueryWrapper<T> setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
        return this;
    }

    public T getData() {
        return data;
    }

    public PageQueryWrapper<T> setData(T data) {
        this.data = data;
        return this;
    }
}
