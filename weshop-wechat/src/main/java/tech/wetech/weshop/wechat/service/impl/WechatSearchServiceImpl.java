package tech.wetech.weshop.wechat.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.utils.Constants;
import tech.wetech.weshop.marketing.api.KeywordsApi;
import tech.wetech.weshop.marketing.api.SearchHistoryApi;
import tech.wetech.weshop.marketing.po.Keywords;
import tech.wetech.weshop.marketing.po.SearchHistory;
import tech.wetech.weshop.wechat.service.WechatSearchService;
import tech.wetech.weshop.wechat.vo.SearchIndexVO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WechatSearchServiceImpl implements WechatSearchService {

    @Autowired
    private KeywordsApi keywordsApi;

    @Autowired
    private SearchHistoryApi searchHistoryApi;

    @Override
    public List<String> helper(String keyword) {
        return keywordsApi.queryByKeyword(keyword);
    }

    @Override
    public void clearHistory() {
        searchHistoryApi.delete(new SearchHistory().setUserId(Constants.CURRENT_USER_ID));
    }

    @Override
    public SearchIndexVO index() {
        // 取出输入框默认的关键词
        PageHelper.offsetPage(0, 1);
        Keywords defaultKeyword = keywordsApi.queryOne(new Keywords().setIsDefault(true)).getData();
        // 取出热闹关键词
        PageHelper.startPage(1, 10);
        List<Keywords> hotKeywordList = keywordsApi.queryList(new Keywords().setHot(true)).getData();

        PageHelper.startPage(1, 10);
        List<String> historyKeywordList = searchHistoryApi.queryList(new SearchHistory().setUserId(Constants.CURRENT_USER_ID)).getData().stream()
                .map(SearchHistory::getKeyword)
                .collect(Collectors.toList());

        return new SearchIndexVO()
                .setDefaultKeyword(defaultKeyword)
                .setHotKeywordList(hotKeywordList)
                .setHistoryKeywordList(historyKeywordList);
    }
}
