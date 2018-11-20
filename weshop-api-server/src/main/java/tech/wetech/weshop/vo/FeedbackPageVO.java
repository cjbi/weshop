package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Feedback;

import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
public class FeedbackPageVO {

    private List<Feedback> list;

    private Pagination pagination;

    private Map<String, Object> extra;

    public List<Feedback> getList() {
        return list;
    }

    public void setList(List<Feedback> list) {
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
