package tech.wetech.weshop.vo;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
public class PageInfoVO<T> {

    private List<T> list;

    private Pagination pagination;

    private Map<String, Object> extra;

    public PageInfoVO(PageInfo pageInfo) {
        this.list = pageInfo.getList();
        this.pagination = new Pagination(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    public PageInfoVO(Builder builder) {
        if (builder.list != null) {
            this.list = builder.list;
        } else {
            this.list = builder.pageInfo.getList();
        }
        if (builder.pagination != null) {
            this.pagination = builder.pagination;
        } else {
            this.pagination = new Pagination(builder.pageInfo.getPageNum(), builder.pageInfo.getPageSize(), builder.pageInfo.getTotal());
        }
        this.extra = builder.extra;
    }

    public static class Builder<T> {

        private PageInfo pageInfo;

        private List<T> list;

        private Map<String, Object> extra;

        private Pagination pagination;

        public Builder(List<T> list) {
            this.list = list;
        }

        public Builder(PageInfo pageInfo) {
            this.pageInfo = pageInfo;
        }

        public Builder addExtra(String key, Object value) {
            if (extra == null) {
                extra = new HashMap<>(16);
            }
            extra.put(key, value);
            return this;
        }

        public Builder pagination(Pagination pagination) {
            this.pagination = pagination;
            return this;
        }

        public PageInfoVO build() {
            return new PageInfoVO(this);
        }

    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }


    public static class Pagination {

        private int current;

        private int pageSize;

        private long total;

        public Pagination(int current, int pageSize, long total) {
            this.current = current;
            this.pageSize = pageSize;
            this.total = total;
        }

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

}
