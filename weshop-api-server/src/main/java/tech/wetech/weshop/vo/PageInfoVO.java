package tech.wetech.weshop.vo;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cjbi
 */
public class PageInfoVO<T> extends PageInfo {

    private Map<String, Object> extra;

    public PageInfoVO(PageInfo pageInfo) {
        this.setPageNum(pageInfo.getPageNum());
        this.setPageSize(pageInfo.getPageSize());
        this.setSize(pageInfo.getPageSize());
        this.setStartRow(pageInfo.getPageSize());
        this.setEndRow(pageInfo.getEndRow());
        this.setTotal(pageInfo.getTotal());
        this.setPages(pageInfo.getPages());
        this.setList(pageInfo.getList());
        this.setFirstPage(pageInfo.getFirstPage());
        this.setPrePage(pageInfo.getPrePage());
        this.setNextPage(pageInfo.getNextPage());
        this.setLastPage(pageInfo.getLastPage());
        this.setIsFirstPage(pageInfo.isIsFirstPage());
        this.setIsLastPage(pageInfo.isIsLastPage());
        this.setHasPreviousPage(pageInfo.isHasPreviousPage());
        this.setHasNextPage(pageInfo.isHasNextPage());
        this.setNavigatePages(pageInfo.getNavigatePages());
        this.setNavigatepageNums(pageInfo.getNavigatepageNums());
        this.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
        this.setNavigateLastPage(pageInfo.getNavigateLastPage());
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public PageInfoVO<T> addExtra(String key, Object value) {
        if (extra == null) {
            extra = new HashMap<>(16);
        }
        extra.put(key, value);
        return this;
    }

}
