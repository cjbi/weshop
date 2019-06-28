package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.query.Criteria;
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
        Keywords defaultKeyword = keywordsApi.queryByCriteria(Criteria.of(Keywords.class).andEqualTo(Keywords::getIsDefault, true).page(1, 1)).getData().get(0);
        // 取出热闹关键词
        List<Keywords> hotKeywordList = keywordsApi.queryByCriteria(Criteria.of(Keywords.class).andEqualTo(Keywords::getHot, true).page(1, 10)).getData();

        List<String> historyKeywordList = searchHistoryApi.queryByCriteria(Criteria.of(SearchHistory.class).andEqualTo(SearchHistory::getUserId, Constants.CURRENT_USER_ID).page(1, 10)).getData().stream()
                .map(SearchHistory::getKeyword)
                .collect(Collectors.toList());

        return new SearchIndexVO()
                .setDefaultKeyword(defaultKeyword)
                .setHotKeywordList(hotKeywordList)
                .setHistoryKeywordList(historyKeywordList);
    }
}
