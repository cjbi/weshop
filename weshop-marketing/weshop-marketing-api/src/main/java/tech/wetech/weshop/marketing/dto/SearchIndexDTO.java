package tech.wetech.weshop.marketing.dto;

import tech.wetech.weshop.marketing.po.Keywords;

import java.util.List;

public class SearchIndexDTO {

    private Keywords defaultKeyword;

    private List<Keywords> hotKeywordList;

    private List<String> historyKeywordList;

    public Keywords getDefaultKeyword() {
        return defaultKeyword;
    }

    public SearchIndexDTO setDefaultKeyword(Keywords defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
        return this;
    }

    public List<Keywords> getHotKeywordList() {
        return hotKeywordList;
    }

    public SearchIndexDTO setHotKeywordList(List<Keywords> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
        return this;
    }

    public List<String> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public SearchIndexDTO setHistoryKeywordList(List<String> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
        return this;
    }
}
