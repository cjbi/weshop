package tech.wetech.weshop.wechat.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.user.api.KeywordsApi;
import tech.wetech.weshop.user.api.SearchHistoryApi;
import tech.wetech.weshop.user.po.Keywords;
import tech.wetech.weshop.user.po.SearchHistory;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.exception.WeshopWechatException;
import tech.wetech.weshop.wechat.service.WechatSearchService;
import tech.wetech.weshop.wechat.utils.JwtHelper;
import tech.wetech.weshop.wechat.vo.SearchIndexVO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WechatSearchServiceImpl implements WechatSearchService {

    @Autowired
    private KeywordsApi keywordsApi;

    @Autowired
    private SearchHistoryApi searchHistoryApi;

    private final Logger log = LoggerFactory.getLogger(WechatSearchServiceImpl.class);

    @Override
    public List<String> helper(String keyword) {
        return keywordsApi.queryByKeyword(keyword).getData();
    }

    @Override
    public void clearHistory() {
        User userInfo = JwtHelper.getUserInfo();
        searchHistoryApi.delete(new SearchHistory().setUserId(userInfo.getId()));
    }

    @Override
    public SearchIndexVO index() {
        // 取出输入框默认的关键词
        Keywords defaultKeyword = keywordsApi.queryOneByCriteria(Criteria.of(Keywords.class).andEqualTo(Keywords::getIsDefault, true).page(1, 1)).getData();
        // 取出热闹关键词
        List<Keywords> hotKeywordList = keywordsApi.queryByCriteria(Criteria.of(Keywords.class).andEqualTo(Keywords::getHot, true).page(1, 10)).getData();
        List<String> historyKeywordList = Collections.emptyList();
        try {
            User userInfo = JwtHelper.getUserInfo();
            historyKeywordList = searchHistoryApi.queryByCriteria(Criteria.of(SearchHistory.class).andEqualTo(SearchHistory::getUserId, userInfo.getId()).page(1, 10)).getData().stream()
                .map(SearchHistory::getKeyword)
                .collect(Collectors.toList());
        } catch (WeshopWechatException e) {
            log.info("用户未登陆，不查询热闹关键词");
        }
        return new SearchIndexVO()
            .setDefaultKeyword(defaultKeyword)
            .setHotKeywordList(hotKeywordList)
            .setHistoryKeywordList(historyKeywordList);
    }
}
