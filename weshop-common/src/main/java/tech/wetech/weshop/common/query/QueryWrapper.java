package tech.wetech.weshop.common.query;

public class QueryWrapper {

    private PageQuery pageQuery;

    private Object condition;

    public QueryWrapper() {
    }

    public QueryWrapper(PageQuery pageQuery, Object condition) {
        this.pageQuery = pageQuery;
        this.condition = condition;
    }

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public QueryWrapper setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
        return this;
    }

    public Object getCondition() {
        return condition;
    }

    public QueryWrapper setCondition(Object data) {
        this.condition = data;
        return this;
    }
}
