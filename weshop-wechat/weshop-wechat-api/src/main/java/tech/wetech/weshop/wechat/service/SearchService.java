package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.wechat.dto.SearchIndexDTO;

import java.util.List;

public interface SearchService {

    List<String> helper(String keyword);

    void clearHistory();

    SearchIndexDTO index();

}
