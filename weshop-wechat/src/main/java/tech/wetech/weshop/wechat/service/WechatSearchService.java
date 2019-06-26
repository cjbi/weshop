package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.wechat.vo.SearchIndexVO;

import java.util.List;

public interface WechatSearchService {

    List<String> helper(String keyword);

    void clearHistory();

    SearchIndexVO index();

}
