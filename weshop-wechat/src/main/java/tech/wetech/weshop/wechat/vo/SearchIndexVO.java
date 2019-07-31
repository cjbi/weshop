package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.user.po.Keywords;

import java.util.List;

public class SearchIndexVO {

    private Keywords defaultKeyword;

    private List<Keywords> hotKeywordList;

    private List<String> historyKeywordList;

    public Keywords getDefaultKeyword() {
        return defaultKeyword;
    }

    public SearchIndexVO setDefaultKeyword(Keywords defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
        return this;
    }

    public List<Keywords> getHotKeywordList() {
        return hotKeywordList;
    }

    public SearchIndexVO setHotKeywordList(List<Keywords> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
        return this;
    }

    public List<String> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public SearchIndexVO setHistoryKeywordList(List<String> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
        return this;
    }
}
