package tech.wetech.weshop.query;

public class WrapperPageQuery<T> {

    private PageQuery pageQuery;

    private T data;

    public WrapperPageQuery() {
    }

    public WrapperPageQuery(T data, PageQuery pageQuery) {
        this.data = data;
        this.pageQuery = pageQuery;
    }

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public WrapperPageQuery<T> setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
        return this;
    }

    public T getData() {
        return data;
    }

    public WrapperPageQuery<T> setData(T data) {
        this.data = data;
        return this;
    }
}
