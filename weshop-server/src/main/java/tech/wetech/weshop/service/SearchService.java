package tech.wetech.weshop.service;

import tech.wetech.weshop.vo.SearchIndexVO;

import java.util.List;

public interface SearchService {

    List<String> helper(String keyword);

    void clearHistory();

    SearchIndexVO index();

}
