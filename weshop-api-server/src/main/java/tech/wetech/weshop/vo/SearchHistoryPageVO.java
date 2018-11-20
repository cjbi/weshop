package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.SearchHistory;

import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
public class SearchHistoryPageVO {

    private List<SearchHistory> list;

    private Pagination pagination;

    private Map<String, Object> extra;

    public List<SearchHistory> getList() {
        return list;
    }

    public void setList(List<SearchHistory> list) {
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
}
